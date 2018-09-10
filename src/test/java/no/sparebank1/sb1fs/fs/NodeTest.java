package no.sparebank1.sb1fs.fs;

import org.junit.Test;

import java.util.Collections;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class NodeTest {


    @Test
    public void testPathResolution() {

        DirNode root = new DirNode("/", asList(
                new FileNode("a.txt", "acontent"),
                new FileNode("b.txt", "bcontent"),
                new DirNode("subfolder-1", Collections.emptyList()),
                new DirNode("subfolder-2", asList(new FileNode("2-a.txt", "2-acontent")))));


        System.out.println(root.getFilesystemTree());



        assertArrayEquals("acontent".getBytes(), root.resolve("/a.txt").getBytes());
        assertArrayEquals("2-acontent".getBytes(), root.resolve("/subfolder-2/2-a.txt").getBytes());
        assertEquals("subfolder-1", root.resolve("/subfolder-1").getName());
        assertEquals("subfolder-2", root.resolve("/subfolder-2").getName());


        assertNull(root.resolve("/a.tx"));
        assertNull(root.resolve("/subfolder-2/a.tx"));
        assertNull(root.resolve("/s/u/b/f"));

        assertEquals(4, root.resolve("/").getSubNodes().size());
    }
}