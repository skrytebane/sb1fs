package no.sparebank1.sb1fs.fs;

import java.time.Instant;
import java.util.Collections;
import java.util.List;

public class FileNode extends Node {
    public FileNode(String name, String content) {
        this(name,content, Instant.now().toEpochMilli());
    }

    public FileNode(String name, String content, long modifiedTimeStampMillis) {
        this(name, content != null ? content.getBytes() : new byte[0], modifiedTimeStampMillis);
    }

    protected FileNode(String name, byte[] content, long modifiedTimeStampMillis) {
        super(name, content, modifiedTimeStampMillis);
    }

    @Override
    public List<Node> getSubNodes() {
        return Collections.emptyList();
    }


    @Override
    public boolean isDir() {
        return false;
    }

    @Override
    public Node resolve(String path) {
        return  ("/" + getName()).equals(path) ? this : null;
    }

    @Override
    public String printRecursive(String currentIndent) {
        return currentIndent + toString() + '\n';
    }

    @Override
    public String toString() {
       return getName();
    }
}
