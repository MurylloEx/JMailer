package br.com.muryllo.jmailer;

public class MailerResponse {
  
  private String request_id = "";
  private MailerResponseData data;

  /**
   * Retorna o Id da solicitação de envio de email.
   * 
   * @return O Id da solicitação de email.
   */
  public String getRequestId() {
    return request_id;
  }

  /**
   * Retorna alguns metadados como o id do email e o número de emails enviados e rejeitados.
   * 
   * @return Metadados da solicitação do envio do email.
   */
  public MailerResponseData getData() {
    return data;
  }

  /**
   * Retorna um booleano indicando se o email foi enviado com sucesso.
   * 
   * @return Um valor booleano.
   */
  public boolean success(){
    if (this.data != null){
      return (this.data.getSucceeded() > 0) && (this.data.getFailed() == 0);
    }
    return false;
  }
  
}
