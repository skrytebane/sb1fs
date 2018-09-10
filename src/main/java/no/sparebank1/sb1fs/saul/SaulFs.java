package no.sparebank1.sb1fs.saul;

import no.sparebank1.sb1fs.fs.DirNode;
import no.sparebank1.sb1fs.fs.FileNode;
import no.sparebank1.sb1fs.saul.dto.Episode;
import no.sparebank1.sb1fs.saul.dto.SaulShow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static java.util.Arrays.stream;
import static java.util.stream.Stream.of;

public class SaulFs {

    public static DirNode createSaulRoot(SaulShow saulShow) {
        Map<Long, List<Episode>> episodesBySeason = stream(saulShow.getEmbedded().getEpisodes()).collect(Collectors.groupingBy(Episode::getSeason));

        DirNode root = new DirNode("/", episodesBySeason.keySet().stream().map(season ->
                new DirNode(saulShow.getName() + "-season-"+season, episodesBySeason.get(season).stream().flatMap(episode ->
                        of(new FileNode(episode.getNumber()+"-" + episode.getName() + ".txt", getEpisodeDescription(episode), getTimestamp(episode)),
                           new ImageFileNode(episode.getNumber()+".jpg", getImageUrl(episode),  getTimestamp(episode))))

                        .collect(Collectors.toList()))).collect(Collectors.toList()));

        return root;
    }

    private static long getTimestamp(Episode episode)  {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(episode.getAirdate()).getTime();
        } catch (ParseException e) {
            return 0;
        }
    }

    private static class  ImageFileNode extends FileNode {
        private static Logger LOG = LoggerFactory.getLogger(ImageFileNode.class);

        public ImageFileNode(String name, String url, Long t)  {
            super(name, downloadUrl(url), t);
        }

        private static byte[] downloadUrl(String url) {
            if (url == null) {
                return new byte[0];
            }

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] chunk = new byte[4096];
            int bytesRead;
            try(InputStream stream = new URL(url).openStream()) {
                while ((bytesRead = stream.read(chunk)) > 0) {
                    outputStream.write(chunk, 0, bytesRead);
                }
            } catch (IOException e) {
                LOG.warn(format("Failed downloading '%s'", url), e);
                return new byte[0];
            }


            byte[] b = outputStream.toByteArray();
            LOG.info(format("Downloaded '%s': %db", url, b.length));
            return b;
        }
    }

    private static String getImageUrl(Episode e) {
        if (e.getImage() != null && e.getImage().getMedium() != null) {
            return e.getImage().getMedium();
        } else {
            return null;
        }
    }

    private static String getEpisodeDescription(Episode e) {
        if (e.getSummary() != null) {
            return e.getSummary().replaceAll("<[^>]*>", "");
        } else {
            return "";
        }
    }
}
