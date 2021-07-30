package br.com.muryllo.jmailer;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.MediaType;

public class Mailer {
  
  private static final String SMTP_API_URL = "https://api.smtp2go.com/v3/";
  private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

  private String m_SecretKey = "";
  private String m_SenderName = "";
  private String m_SenderEmail = "";
  private ArrayList<String> m_Recipients = new ArrayList<>();
  private String m_SubjectText = "";
  private String m_TextBody = "";
  private String m_HtmlBody = "";

  /**
   * Define a chave da api de envio de emails.
   * 
   * @param seckey A chave da API SMTP2GO usada para enviar os emails.
   * @return A instância do Mailer.
   */
  public Mailer key(String seckey){
    this.m_SecretKey = seckey;
    return this;
  }

  /**
   * Define quem enviou o email.
   * Perceba que essa campo pode ser forjado, você pode enviar o email sendo quem quiser.
   * 
   * @param senderName O nome do remetente.
   * @param senderEmail O eendereço de email do remetente
   * @return A instância do Mailer.
   */
  public Mailer from(String senderName, String senderEmail){
    this.m_SenderName = senderName;
    this.m_SenderEmail = senderEmail;
    return this;
  }

  /**
   * Define para quem será enviado o email.
   * 
   * @param recipientName O nome do destinatário.
   * @param recipientEmail O endereço de email do destinatário.
   * @return A instância do Mailer.
   */
  public Mailer to(String recipientName, String recipientEmail){
    this.m_Recipients.add(
      String.format("%s <%s>", recipientName, recipientEmail));
    return this;
  }

  /**
   * Define o título do email (assunto).
   * 
   * @param text O título do email que aparecerá para o destinatário.
   * @return A instância do Mailer.
   */
  public Mailer subject(String text){
    this.m_SubjectText = text;
    return this;
  }

  /**
   * Define o corpo do texto do email a ser enviado.
   * 
   * @param text O corpo do texto do email.
   * @return A instância do Mailer.
   */
  public Mailer textBody(String text){
    this.m_TextBody = text;
    return this;
  }

  /**
   * Define o corpo HTML do email a ser enviado.
   * É possível enviar emails estilizados com html e css.
   * 
   * @param html O corpo HTML do email. Ele deve ser feito em padrão HTML5.
   * @return A instância do Mailer.
   */
  public Mailer htmlBody(String html){
    this.m_HtmlBody = html;
    return this;
  }

  /**
   * Envia o email para o destinatário solicitado de forma síncrona.
   * 
   * @return Retorna a resposta do servidor SMTP em formato JSON.
   */
  public MailerResponse send(){
    try{
      Envelope envelope = new Envelope()
        .setApiKey(this.m_SecretKey)
        .setTo(this.m_Recipients)
        .setSender(String.format("%s <%s>", this.m_SenderName, this.m_SenderEmail))
        .setSubject(this.m_SubjectText)
        .setTextBody(this.m_TextBody)
        .setHtmlBody(this.m_HtmlBody);
      
      String envelopeJson = JsonService.stringify(envelope, Envelope.class);
      RequestBody reqBody = RequestBody.create(envelopeJson, JSON);
  
      Map<String, String> queryString = new Hashtable<String, String>();
      Map<String, String> headers = new Hashtable<String, String>();
      
      headers.put("Content-Type", "application/json; charset=utf-8");
    
      String response = RequestService.post(
        SMTP_API_URL + "/email/send", 
        reqBody, 
        headers, 
        queryString);
      
      return JsonService.parse(response, MailerResponse.class);
    } catch(Exception exception){
      return new MailerResponse();
    }
  }

}
