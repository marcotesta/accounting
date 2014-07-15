package it.mondogrua.lab.accounting;

public interface Processor {

    public void process(Node<? extends Element> node);

    public void process(Center center);
}
