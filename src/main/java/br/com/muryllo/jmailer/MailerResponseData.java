package br.com.muryllo.jmailer;

public class MailerResponseData {

  private long succeeded = 0;
  private long failed = 0;
  private String email_id = "";

  /**
   * Retorna o número de emails enviados com sucesso.
   * 
   * @return O número de emails enviados com sucesso.
   */
  public long getSucceeded() {
    return succeeded;
  }

  /**
   * Retorna o número de emails não enviados ou rejeitados.
   * 
   * @return Número de emails não enviados ou rejeitados.
   */
  public long getFailed() {
    return failed;
  }
  
  /**
   * Retorna um ID do email no SMTP2GO.
   * 
   * @return Um Id do email enviado válido no SMTP2GO.
   */
  public String getEmailId() {
    return email_id;
  }

}
