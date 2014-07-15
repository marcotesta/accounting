package it.mondogrua.lab.accounting;

public class Printer implements Processor {

    private final StringBuilder _output;

    public Printer(StringBuilder output) {
        super();
        this._output = output;
    }



    @Override
    public void process(Node<? extends Element> node) {
        for (int i=0; i<node.getLevel(); ++i) {
            _output.append("  ");
        }
    }
    
    @Override
    public void process(Center center) {
        _output.append(center.name()).append("\n");
    }

}
