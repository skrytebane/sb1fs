package no.sparebank1.sb1fs.fs;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DirNode extends Node {
    protected final List<Node> subDirs;

    public DirNode(String name,List<Node> subNodes) {
        super(name, new byte[0], Instant.now().toEpochMilli());
        this.subDirs=subNodes;
    }

	public DirNode(String name) {
		this(name,new CopyOnWriteArrayList<>());
	}

    @Override
	public List<Node> getSubNodes() {
		return subDirs;
	}

    @Override
    public boolean isDir() {
        return true;
    }

    @Override
    public Node resolve(String path) {
        if (path==null || ! path.startsWith("/")) {
            System.out.println("Strange path: " + path);
            System.exit(0);
        }

        if (getName().equals("/") && path.equals("/")) {
            return this;
        }

        if  (("/" + getName()).equals(path)) {
            return this;
        }

        for(Node subNode: getSubNodes() ) {
            Node resolvedNode = subNode.resolve(getName().equals("/") ? path : path.replaceFirst("\\/" + getName(), ""));
            if (resolvedNode != null) {
                return resolvedNode;
            }
        }

        return null;
    }


    public String printRecursive(String currentIndent) {
        StringBuffer sb = new StringBuffer();
        sb.append(currentIndent).append(toString()).append('\n');

        getSubNodes().forEach(node -> sb.append(node.printRecursive(currentIndent + "  ")));

        return sb.toString();
    }

    @Override
    public String toString() {
        return getName()+"/";
    }
}
