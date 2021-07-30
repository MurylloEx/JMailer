<h1 align="center">jmailer</h1>
<p align="center">Esta é uma biblioteca simples e pragmática para envio de e-mails em sistemas feitos sob Java.</p>

<p align="center">
  <img src="https://badgen.net/badge/license/MIT/green"/>
  <img src="https://badgen.net/badge/service/SMTP2GO/blue?icon=label">
  <img src="https://badgen.net/badge/author/Muryllo/yellow?icon=label"/>
</p>

Você precisará apenas de uma chave de api fornecida por SMTP2GO para utilizar a biblioteca.

## Instalation (Maven)

Adicione o seguinte trecho dentro da tag <dependencies> em seu arquivo pom.xml

```xml
<dependency>
  <groupId>com.squareup.okhttp3</groupId>
  <artifactId>okhttp</artifactId>
  <version>4.9.0</version>
</dependency>
<dependency>
  <groupId>br.com.muryllo.jmailer</groupId>
  <artifactId>jmailer</artifactId>
  <version>1.2.2</version>
</dependency>
```

Utilize este trecho de código para enviar seus emails, mude-o como quiser e achar melhor.

```java
Mailer mail = new Mailer()
  .key("<your-api-key>")
  .subject("Teste de Email!")
  .from("Teste", "teste@muryllo.com.br")
  .to("Muryllo Pimenta", "muryllo.pimenta@upe.br")
  .htmlBody("<h1>Confirmação de cadastro</h1>");

MailerResponse result = mail.send();
System.out.println(result.success());
```

## Metadata

Muryllo Pimenta de Oliveira – muryllo.pimenta@upe.br

Distribuído sobre a licença MIT. Veja ``LICENSE`` para mais informações.

## Contributing

1. Fork it (<https://github.com/MurylloEx/JMailer/fork>)
2. Create your feature branch (`git checkout -b feature/fooBar`)
3. Commit your changes (`git commit -am 'Add some fooBar'`)
4. Push to the branch (`git push origin feature/fooBar`)
5. Create a new Pull Request

