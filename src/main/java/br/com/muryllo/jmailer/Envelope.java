package br.com.muryllo.jmailer;

import java.util.List;

/**
 * Essa classe está disponível para uso interno.
 * Utilizá-la diretamente por sua própria conta pode trazer problemas. 
 * Utilize a classe Mailer se quiser enviar os emails da forma mais adequada.
 */
public class Envelope {
  
  private String api_key;
  private List<String> to;
  private String sender;
  private String subject;
  private String text_body;
  private String html_body;

  public String getApiKey() {
    return api_key;
  }

  public Envelope setApiKey(String api_key) {
    this.api_key = api_key;
    return this;
  }

  public List<String> getTo() {
    return to;
  }

  public Envelope setTo(List<String> to) {
    this.to = to;
    return this;
  }
  
  public String getSender() {
    return sender;
  }

  public Envelope setSender(String sender) {
    this.sender = sender;
    return this;
  }

  public String getSubject() {
    return subject;
  }

  public Envelope setSubject(String subject) {
    this.subject = subject;
    return this;
  }

  public String getTextBody() {
    return text_body;
  }

  public Envelope setTextBody(String text_body) {
    this.text_body = text_body;
    return this;
  }

  public String getHtmlBody() {
    return html_body;
  }

  public Envelope setHtmlBody(String html_body) {
    this.html_body = html_body;
    return this;
  }

}
