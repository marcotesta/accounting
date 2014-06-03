package it.mondogrua.lab.accounting;

public class Printer implements Processor {

    private final StringBuilder _output;



    public Printer(StringBuilder output) {
        super();
        this._output = output;
    }



    @Override
    public void process(Center center, int depth) {
        for (int i=0; i<depth; ++i) {
            _output.append("  ");
        }
        _output.append(center.name()).append("\n");
    }

}
