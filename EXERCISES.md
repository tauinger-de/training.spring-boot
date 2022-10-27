# EXERCISES

## 040 Migration

Migrieren Sie die in diesem Branch vorliegende Anwendung auf Spring Boot.

Dies beinhaltet insbesondere:

- Änderung der `pom.xml`
- Entfernung so vieler Bean Definitionen wie möglich aus der `context.xml` und Nutzung
von Annotationen
- Import der verbleibenden `context.xml` Bean Definitionen
- Umzug der Konfiguration in `application.properties` und Nutzung `@Value` Annotationen
oder `@ConfigurationProperties` Klassen
- Migration der Servlets
- Entfernung `web.xml`