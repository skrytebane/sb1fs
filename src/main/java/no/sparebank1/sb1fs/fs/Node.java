package no.sparebank1.sb1fs.fs;

import java.util.List;

public abstract class Node {

    private final String name;
    private final byte[] bytes;
    private final long modifiedTimeStampMillis;

    protected Node(String name, byte[] bytes, long modifiedTimeStampMillis) {
        this.name = name;
        this.bytes = bytes;
        this.modifiedTimeStampMillis = modifiedTimeStampMillis;
    }

    public String getName() { return name; }
	public byte[] getBytes() { return bytes; }
	public long modifiedTimeStampMillis() { return modifiedTimeStampMillis; }

    public abstract List<Node> getSubNodes();
    public abstract boolean isDir();

    /**
     * @return Node matching the path. Returns null if no matching path is found
     */
    public abstract Node resolve(String path);


    public String getFilesystemTree() {
        return printRecursive("");
    }

    protected abstract String printRecursive(String currentIndent);
}
