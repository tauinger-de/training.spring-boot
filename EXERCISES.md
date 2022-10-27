# EXERCISES

## 020 Bean Definitions

### Projekt

Legen Sie mithilfe des Spring Initializr ein neues Spring Boot Projekt an ("my-spring-boot-project"). Dies kann

- über die Website https://start.spring.io/ und Download der generierten Dateien geschehen
- oder mithilfe Ihrer IDE, z.B. in Intellij via "File >> New >> Project..." und dann Auswahl "Spring Initializr" links

### Klassen

1. Legen Sie in dem neuen Projekt eine Klasse `SumCalculator` mit der Methode `int sum(int term1, int term2)` an
2. Legen Sie eine Klasse `PowerOfCalculator` mit der Methode `int powerOf(int exponent, int power)` an. Diese hat einen
   einzigen Konstruktor, der einen `boolean` Parameter benötigt. Dieser bestimmt, ob eine Log-Ausgabe vor der Berechnung
   erfolgt oder nicht
3. Legen Sie eine Klasse `MathService` an. Diese hat eine Referenz auf beide oben angelegte Kalkulatoren und
   definiert eine Methode `int calculateTwoPlusThreeToThePowerOfFour()`, die Sie mithilfe der Kalkulatoren
   implementieren
4. Legen Sie eine Klasse `DebugRunner` an, die eine Referenz auf `MathService` hat und dessen Methode aufruft und
   das Ergebnis auf `System.out` schreibt

### Beans

1. Führen Sie die notwendigen Schritte aus, damit Spring die oben definierten Klassen als Spring Beans instanziiert
   und verdrahtet
2. Lassen Sie den DebugRunner das Interface `CommandLineRunner` implementieren
3. Starten Sie Ihre Spring Anwendung -- das Ergebnis der Berechnung sollte nun ausgegeben werden

## 030 Config
