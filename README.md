# Forum Applikation

Dieses Repository ist die Vorlage für eine Forum Applikation. In dem Forum können Nutzer Threads mit einem Titel und Text erstellen. Nutzer können auf diesen Threads Kommentare schreiben.

Das Frontend der Applikation ist bereits einsatzbereit. Jedoch ist das Backend noch lückenhaft. Deine Aufgabe ist es, das Backend zu vervollständigen, so dass die Applikation vollumfänglich funktioniert.

## Endpunkte analysieren

Sieh dir die Endpunkte im `ThreadController` an und überlege dir, wie eine Anfrage an diese Endpunkte aussehen könnte. Dafür musst du auch die Entitäten im `data` Package anschauen.

- In welcher Form werden Parameter übergeben?
- Was erwartest du jeweils als Antwort?

Erstelle Für jeden Endpunkt eine Hoppscotch Anfrage. Diese wird noch nicht erfolgreich sein, da die Applikation noch nicht implementiert ist.

## Business Logik implementieren

> Für diese Übung musst du nur den `ThreadController` und `ThreadService` bearbeiten.

Implementiere nun Schritt für Schritt für jeden Endpunkt die Business Logik. Diese gehört in den `ThreadController`. Prüfe mit deinen Hoppscotch Anfragen, ob deine Implementation funktioniert.

## Applikation prüfen

Starte die Spring Applikation und besuche in deinem Browser [http://localhost:8080](http://localhost:8080). Prüfe, ob die Applikation funktioniert.

## Applikation im Netzwerk bereitstellen

Wenn deine Applikation funktioniert, kannst du sie im Netzwerk bereitstellen. Finde dazu deine IP-Adresse im Coop Netzwerk heraus. Füge danach folgende Zeile in der Datei `src/main/resources/application.properties` hinzu:

```yml
sever.address=<ip-address>
# z.b:
# server.address=192.168.10.15
```

Wenn du nun die Applikation neu startest sollten andere Geräte über die Adresse `http://<ip-address>:8080` darauf zugreifen können.