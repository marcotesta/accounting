package it.mondogrua.lab.accounting;

import java.util.LinkedList;

import java.util.Queue;

public class LevelOrderBranchIterator implements InternalIterator {

    private final Center _root;
    public LevelOrderBranchIterator(Center _root) {
        super();
        this._root = _root;
    }



    @Override
    public void traverse(Processor processor) {
        Queue<Node> level  = new LinkedList<Node>();
        level.add(new Node(_root,0));
        while(!level.isEmpty()){
            Node node = level.poll();
            processor.process(node.center, node.level);
            for (Center child : node.center) {
                level.add(new Node(child, node.level+1));
            }
        }
    }

    class Node {
        Center center;
        int level;

        public Node(Center center, int level) {
            this.center = center;
            this.level = level;
        }
    }

}
