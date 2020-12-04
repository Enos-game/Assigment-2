////////////////////////////////////////////////////////////////////
// [Lorenzo] [Piran] [1193526]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business.exception;

public class BillException extends Exception{
    private String messaggioDiErrore;
    public String getMessagge() {
      return messaggioDiErrore;
    }
    public BillException(String messaggioDiErrore) {
      super();
      this.messaggioDiErrore = messaggioDiErrore;
    }
}
