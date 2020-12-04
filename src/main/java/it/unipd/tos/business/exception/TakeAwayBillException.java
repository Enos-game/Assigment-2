package it.unipd.tos.business.exception;

public class TakeAwayBillException extends Exception{
    private String messaggioDiErrore;
    public String getMessagge() {
      return messaggioDiErrore;
    }
    public TakeAwayBillException(String messaggioDiErrore) {
      super();
      this.messaggioDiErrore = messaggioDiErrore;
    }
}
