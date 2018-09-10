package no.sparebank1.sb1fs.saul;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import jnr.ffi.Platform;
import no.sparebank1.sb1fs.app.Sb1FsApplication;
import no.sparebank1.sb1fs.fs.DirNode;
import no.sparebank1.sb1fs.fs.Sb1fs;
import no.sparebank1.sb1fs.saul.dto.SaulShow;
import no.sparebank1.sb1fs.saul.http.OldSchoolHttpServer;
import no.sparebank1.sb1fs.util.Java8Util;
import no.sparebank1.sb1fs.util.UniRest;
import org.apache.commons.cli.CommandLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.System.exit;
import static no.sparebank1.sb1fs.util.CommandLine.*;

public class SaulFsApplication {

    private static Logger LOG = LoggerFactory.getLogger(Sb1FsApplication.class);

    public static void main(String[] args) {
        CommandLine commandLine = generateCommandLine(args);

        if (commandLine.hasOption(OPTION_HELP)) {
            printUsage();
            exit(0);
        }

        String mountPath = commandLine.getOptionValue(OPTION_MOUNT_PATH);
        mountPath = setMoutPathOrDefault(mountPath);

        UniRest.configureUnirest();
        OldSchoolHttpServer.serveJson();

        HttpResponse<SaulShow> response = Java8Util.propagate(() -> Unirest
                .get("http://localhost:8080")
                .header("Accept", "application/vnd.sparebank1.v1+json")
                .asObject(SaulShow.class));

        SaulShow jsonRoot = response.getBody();
        DirNode root = SaulFs.createSaulRoot(jsonRoot);

        new Sb1fs(root, mountPath).mount();
    }

    private static String setMoutPathOrDefault(String mountPath) {
        // use user parameter as path
        if (mountPath != null) {
            return mountPath;
        }

        // use default path
        switch (Platform.getNativePlatform().getOS()) {
            case WINDOWS:
                return "S:\\";
            default:
                return "/tmp/sb1fs";
        }
     }
}
