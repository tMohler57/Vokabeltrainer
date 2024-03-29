# Vokabeltrainer

Programmieren II / Software Engineering Projekt

#### Mitglieder: 
Isabelle Dittmann: SCRUM Master / Entwickler

Karolina Schmidt: Oberflächen Designer / Entwickler

Morgan Farnworth: Software Architect / Entwickler

Tanja Mohler: Product Owner / Entwickler

## Inhaltsverzeichnis

1. [Einleitung](#einleitung)
   1. Ziele
   1. Randbedingungen
1. [Build-Anleitung](#build-anleitung)
1. [Kurze Bedienungsanleitung](#bedienungsanleitung)
1. [User Stories und Anreicherung der User Stories für die Umsetzung](#userstories)
1. [Releaseplan](#releaseplan)
1. [UML Package, Klassen- und Sequenzdiagramm](#klassendiagramm)
1. [Herleitung der Testfälle aus den Akzeptanzkriterien der User Stories](#testfälle)
1. [Dokumentation Sprint 1](#dokumentationSprint1)
   1. Taskliste für die Umsetzung der User Story
   1. Erfahrungen und Anpassungen
1. [Dokumentation Sprint 2](#dokumentationSprint2)
   1. Taskliste für die Umsetzung der User Story
   1. Erfahrungen und Anpassungen
1. [Dokumentation Sprint 3](#dokumentationSprint3)
   1. Taskliste für die Umsetzung der User Story
   1. Erfahrungen und Anpassungen
1. [Dokumentation wichtiger Code Snippets](#snippets)

<a name="einleitung"/>

## 1. Einleitung
Bei unserem Projekt handelt es sich um einen Vokabeltrainer. Der Nutzer möchte Vokabeln lernen, ohne den Hintergrund der Programmierung zu kennen. Er nutzt nur das ihm zur Verfügung gestellte Interface. Ihm ist wichtig, dass das Programm einfach zu bedienen ist.
Ziel dieses Projektes ist es, dass der Nutzer seinen Wortschatz verbessern kann, in dem er sich in der Übersetzung der von uns vorgeschlagenen Vokabeln übt.

### i. Ziele
Im Rahmen des Moduls Software Engineering und Informatik II entwickeln wir Studierenden eine etwas komplexere Software, um den zuvor gelernten Stoff durch die Implementierung einer lauffähigen Applikation zu vertieften.

### ii. Randbedingungen:
- Die Programmierung der Anwendung erfolgt in Java.
- Das Projekt ist auf GitHub öffentlich einsehbar.
- Das Projekt wurde getestet.
- Das Projekt wurde mit dem Git-Workflow Vincent Driessen erstellt.
- Die Build-Automatisierung erfolgt mittels Gradle.
- Das Projekt wurde mit der SCRUM Methode durchgeführt. Dies beinhaltet Userstories und einen Releaseplan.

<a name="build-anleitung"/>

## 2. Build-Anleitung

### Build Prozess mit Gradle

Führen Sie folgende Befehle in der Git Bash aus, um das Projekt herunterzuladen und den Build-Vorgang einzuleiten:

	git clone https://github.com/tMohler57/Vokabeltrainer.git
	cd Vokabeltrainer
	git checkout release_3
	./gradlew build

Das Programm kann nun mit einem der folgenden Befehlen gestartet werden:

	./gradlew run
	java -jar ./build/libs/Vokabeltrainer-all.jar
	
Tests können mit diesem Befehl ausgeführt werden:

	./gradlew test

Für den Test ist zu beachten, dass die sich öffnenden Fenster durch nichts verdeckt werden und die Maus nicht bewegt wird, da ansonten die automatisierten Unit Tests beeinträchtigt werden.
Die Coverage kann unter dem Pfad "build/reports/coverage" in der Datei "index.html" eingesehen werden. 

### Projekt in Eclipse öffnen

Eclipse kann den Projektordner als existierendes Gradle Projekt importieren. (File->Import...->Existing Gradle Project)

<img src="images/Import.JPG" width="300" >

Zum Starten des Programms muss die Klasse com.vokabeltrainer.Main mit "Run" ausgeführt werden.

Das Projekt wurde mit Java 11 unter Eclipse 2020-09 mit dem e(fx)clipse Plugin entwickelt.

Bei Problemen mit Sonderzeichen muss der Standartzeichensatz auf UTF-8 eingestellt werden. (Window->Preferences->General->Workspace)

<img src="images/UTF-8.JPG" width="300" >

Falls Eclipse das Projekt nicht richtig importiert, kann dies in der Git Bash mit folgendem Befehl behoben werden:

	./gradlew eclipse

<a name="bedienungsanleitung"/>

## 3. Kurze Bedienungsanleitung
Folgend wird beschrieben, wie die Anwendung funktioniert.
- Anwendung gemäss Build-Anleitung starten.
- Es öffnet sich das Startfenster.
- Wählen Sie ein Thema, eine Sprache und die gewünschte Übersetzungsrichtung per Drop Down Menü aus.
- Sobald Sie eine Auswahl für die drei Variablen getroffen haben, können Sie das Vokabeltraining mittels "Start" beginnen.
- Sie werden nun aufgefordert, ein gegebenes Wort zu übersetzen.
- Geben Sie die Übersetzung in das Eingabefeld ein.
- Wenn Sie die Eingabe abgeschlossen haben, drücken Sie auf den Button "Bestätigen". (Beachten Sie, dass das Eingabefeld nicht leer bleiben darf!)
  - Ist Ihre Eingabe richtig, wird Ihnen dies angezeigt. Sie können weiterfahren.
  - Ist Ihre Eingabe falsch, werden Sie darauf aufmerksam gemacht und es wird Ihnen die richtige Antwort angezeigt. Sie können weiterfahren.
- Wenn Sie das Training fortsetzten wollen, drücken Sie auf "Weiter".
  - Nun können Sie die Eingabe wie zuvor durchführen.
- Wenn Sie das Training beenden wollen, drücken Sie auf "Beenden".
  - Ihnen wird nun angezeigt, wie viele Vokabeln Sie geübt haben und wie viele Sie richtig beantwortet haben. Dies wird Ihnen auch als Prozentsatz angezeigt.
  - Sie können das Programm mit "Programm beenden" beenden oder das Training mit "Zurück zum Hauptmenü" wiederholen oder ein neues Training wählen.

Jedes Thema enthält 50 Wörter. Falsch eingegebene Wörter werden wiederholt. Wenn Sie also alle 50 Vokabeln richtig haben, gelangen Sie automatisch zum Endbildschirm.

<a name="userstories"/>

## 4. User Stories und Anreicherung der User Stories für die Umsetzung
| **Titel** |   **User Stories**  |  **Priorität** | **Storypoints** | **Akzeptanzkriterien** |
|:-----:|------|:-:|:-:|-----|
| 1. Programm starten | Als Nutzer möchte ich das Programm starten können, um mit dem Vokabeltraining beginnen zu können. | 1 | 2 | Angenommen das Programm ist bereit, gestartet zu werden, wenn der Start-Button gedrückt wird, dann startet das Programm. |
| 2. Vokabeln zufällig auswählen | Als Nutzer möchte ich, dass ein Wort zufällig ausgewählt wird, um bei jeder Benutzung des Programms andere Vokabeln zu lernen. | 2 | 3 | Angenommen das Programm wurde gestartet, wenn ein Wort zufällig ausgewählt wird, dann wird dem Nutzer dieses Wort zur Übersetzung angezeigt.|
| 3. Vokabeln anzeigen | Als Nutzer möchte ich Vokabeln angezeigt bekommen, um zu wissen, welches Wort ich übersetzen soll.| 1 | 1 | Angenommen das Programm hat ein Wort ausgewählt, wenn dieses Wort zur Übersetzung angezeigt wird, dann wird der Nutzer zur Eingabe aufgefordert. |
| 4. Übersetzung eingeben | Als Nutzer möchte ich eine Übersetzung eingeben können, um meine Vokabelkenntnisse zu trainieren. | 1 | 3 | Angenommen ein zu übersetzendes Wort wird angezeigt, wenn der Nutzer seine Übersetzung eingibt, dann trainiert er seine Vokabelkenntnisse. |
| 5. Eingabe bestätigen | Als Nutzer möchte meine Eingabe bestätigen können, um sie überprüfen zu lassen. | 1 | 1 | Angenommen die Übersetzung des angezeigten Wortes wurde eingegeben, wenn der Nutzer seine Eingabe bestätigt, dann wird die Eingabe angenommen. |
| 6. Übersetzung prüfen | Als Nutzer möchte ich, dass meine eingegebene Übersetzung überprüft wird, um zu wissen, ob meine Übersetzung stimmt. | 2 | 1 | Angenommen eine Übersetzung wurde eingegeben, wenn das Programm die Richtigkeit der Eingabe prüft, dann wird dem Nutzer mitgeteilt, ob seine Eingabe korrekt war. |
| 7. Korrekte Übersetzung anzeigen | Als Nutzer möchte ich, dass die Korrektur angezeigt wird, um zu sehen, ob meine Übersetzung korrekt war. | 1 | 1 | Angenommen die Eingabe wurde bestätigt, wenn eine Übersetzung eingegeben wurde, dann wird die korrekte Lösung angezeigt. |
| 8. Programm beenden | Als Nutzer möchte das Programm jederzeit beenden können, um mit dem Vokabeltraining aufzuhören. | 2 | 2 | Angenommen das Vokabeltraining ist aktiv, wenn der Nutzer das Vokabeltraining beendet, dann wird dem Nutzer seine Erfolgsquote angezeigt. |
| 9. Erfolgsquote | Als Nutzer möchte ich die Anzahl richtiger Antworten sehen, um meine Erfolgsquote zu verfolgen. | 2 | 2 | Angenommen das Programm wird beendet, wenn ein Vokabeltraining absolviert wurde, dann wird die Anzahl richtiger Antworten angezeigt. |
| 10. Thema wählen | Als Nutzer möchte ich ein Thema wählen können, um Wörter aus verschiedenen Bereichen zu lernen. | 3 | 8 | Angenommen das Programm wurde geöffnet, wenn der Nutzer ein Thema wählt, dann werden nur Wörter aus dem zugehörigen Bereich zur Übersetzung ausgewählt. |
| 11. Sprache wählen | Als Nutzer möchte ich wählen können, welche Sprache ich lernen möchte, um das Programm zum erlernen verschiedener Sprachen benutzen zu können. | 3 | 8 | Angenommen das Programm wurde geöffnet, wenn der Nutzer die zu erlernende Sprache wählt, dann wird die Korrektur für die jeweilige Sprache vorgenommen. |
| 12. Übersetzungsrichtung wählen | Als Nutzer möchte ich eine Übersetzungsrichtung wählen können, um die einzugebende Sprache zu verändern. | 3 | 3 | Angenommen das Programm wurde geöffnet, wenn der Nutzer die Übersetzungsrichtung wählt, dann wird die einzugebende Sprache angepasst. |
| 13. Wiederholen schwieriger Vokabeln | Als Nutzer möchte ich Vokabeln, die ich falsch übersetzt habe, noch einmal wiederholen, um diese besser zu lernen. | 3 | 5 | Angenommen eine Übersetzung war inkorrekt, wenn der Nutzer alle zum jeweiligen Thema gehörenden Wörter einmal übersetzt hat, dann werden diese Vokabeln erneut abgefragt. |
| 14. Initialisierung | Als Entwickler möchte ich eine Grundstruktur für mein Programm haben, um mich gut darin zurechtzufinden und alle nötigen Klassen und Dateien zur Verfügung zu haben. | 1 | 8 | Angenommen ich möchte mein Programm schreiben, wenn bereits eine Grundstruktur vorhanden ist, dann ist es einfach, den Überblick zu behalten. |

<a name="releaseplan"/>

## 5. Releaseplan
| **Sprint 1** |   **Sprint 2**  |  **Sprint 3** |
|----|----|----|
| 1. Programm starten | 2. Vokabeln zufällig auswählen | 11. Sprache wählen |  
| 3. Vokabeln anzeigen | 6. Übersetzung prüfen | 12. Übersetzungsrichtung wählen |
| 4. Übersetzung eingeben | 8. Programm beenden | 13. Wiederholen schwieriger Vokablen |
| 5. Eingabe bestätigen | 9. Erfolgsquote |  |
| 7. Korrekte Übersetzung anzeigen | 10. Thema wählen |  |
| 14. Initialisierung |  |  |

Velocity von 16 Storypoints pro Sprint

<a name="klassendiagramm"/>

## 6. UML Package, Klassen- und Sequenzdiagramm

### Packagediagramm
Mit dem Packagediagramm wird die Package Struktur dargestellt.

<img src="images/Packagediagramm.jpg" width="500" >

### Klassendiagramm
Im Klassendiagramm ist die MVC-Struktur und die Beziehung zwischen den einzelnen Klassen deutlich zu erkennen.

<img src="images/Klassendiagramm.jpg" width="1000" >

### Sequenzdiagramm
Das Sequenzdiagramm stellt den Ablauf des Programms dar. Erstellte Objekte sowie deren Lebensdauer werden verdeutlicht.

<img src="images/Sequenzdiagramm.jpg" width="1000" >

<a name="testfälle"/>

## 7. Herleitung der Testfälle aus den Akzeptanzkriterien der User Stories

Die manuellen Testfälle fallen weg. Sie wurden ersetzt durch Unit Tests mit der TestFX Library, welche einen User simulieren kann. Die Tests funktionieren somit vollautomatisch.

In der Spalte "Zugehörige Testklasse" wird die Klasse angegeben, welche hauptsächlich für das Testen der User Story verantwortlich ist. Beim Testing werden jedoch auch noch weiter Aspekte in anderen Testklassen getestet.

| **User Stories** |   **Getestet**  |  **Zugehörige Testklasse** |
|:-----|:-----:|:-----:|
| 1. Programm starten | JA | StartViewTest |
| 2. Vokabeln zufällig auswählen | NEIN | - |
| 3. Vokabeln anzeigen | JA | TrainingsViewTest |
| 4. Übersetzung eingeben | JA | TrainingsViewTest |
| 5. Eingabe bestätigen | JA | TrainingsViewTest |
| 6. Übersetzung prüfen | JA | TrainingsControllerTest |
| 7. Korrekte Übersetzung anzeigen | JA | TrainingsViewTest |
| 8. Programm beenden | JA | EndViewTest |
| 9. Erfolgsquote | JA | EndViewTest |
| 10. Thema wählen | JA | StartViewTest |
| 11. Sprache wählen | JA | StartViewTest |
| 12. Übersetzungsrichtung wählen | JA | StartViewTest |
| 13. Wiederholen schwieriger Vokabeln | JA | TrainingsControllerTest |

<a name="dokumentationSprint1"/>

## 8. Dokumentation Sprint 1
### i. Taskliste für die Umsetzung der User Story
#### User Story 1 - Programm starten (45')
| **Task** |   **Beschreibung**  |  **Aufwandschätzung** |
|:--------:|:--------------------|:---------------------:|
| 1 | Button erstellen | 15' |
| 2 | Action Handler programmieren | 30' |

#### User Story 3 - Vokabeln anzeigen (35')
| **Task** |   **Beschreibung**  |  **Aufwandschätzung** |
|:--------:|:--------------------|:---------------------:|
| 1 | Label erstellen | 15' |
| 2 | Die Vokabel an der Stelle der Zufallszahl des Arrays "vokabeln" mithilfe des Labels ausgeben | 20' |

#### User Story 4 - Übersetzung eingeben (15')
| **Task** |   **Beschreibung**  |  **Aufwandschätzung** |
|:--------:|:--------------------|:---------------------:|
| 1 | Textfeld erstellen | 15' |


#### User Story 5 - Eingabe bestätigen (1h 45')
| **Task** |   **Beschreibung**  |  **Aufwandschätzung** |
|:--------:|:--------------------|:---------------------:|
| 1 | Prüfen, ob Eingabe erlaubt ist | 25' |
| 2 | Label erstellen | 15' |
| 3 | Auf dem Label eine Fehlermeldung ausgeben, falls die Eingabe nicht erlaubt ist | 10' |
| 4 | Ins Textfeld eingegebenen Text einlesen und auf einer String-Variable “eingabe” speichern | 10' |
| 5 | Button erstellen | 15' |
| 6 | Action Handler programmieren | 30' |

#### User Story 7 - Korrekte Übersetzung anzeigen (25')
| **Task** |   **Beschreibung**  |  **Aufwandschätzung** |
|:--------:|:--------------------|:---------------------:|
| 1 | Label erstellen | 15' |
| 2 | Auf dem Label die passende Variable "uebersetzung" ausgeben | 10' |

#### User Story 8 - Programm beenden (45')
| **Task** |   **Beschreibung**  |  **Aufwandschätzung** |
|:--------:|:--------------------|:---------------------:|
| 1 | Button erstellen | 15' |
| 2 | Action Handler programmieren | 30' |

Diese Story wurde aus Sprint 2 übernommen. Siehe Kapitel ii.

#### User Story 14 -Initialisierung (3h 50')
| **Task** |   **Beschreibung**  |  **Aufwandschätzung** |
|:--------:|:--------------------|:---------------------:|
| 1 | Grundstruktur des Programms erstellen (z.B. Klassen, Unterklassen, Main-Methode, usw.) | 2h |
| 2 | Layout des Programmfensters erstellen | 1h |
| 3 | Erste Textdatei schreiben | 30' |
| 4 | Textdatei einlesen | 20' |

### ii. Erfahrungen und Anpassungen
Während der Arbeit am ersten Sprint ist klar geworden, dass es nicht möglich ist, immer jede Story für sich starr abzuarbeiten. Häufig kommt es vor, dass es während der Erarbeitung eines Tasks aus einer Story Sinn macht, auch gleich einen Task einer anderen Story zu bearbeiten, da es einfach zum Workflow passt.
Im Weiteren wurde die Story 8 aus Sprint 2 vorgezogen und bereits in Sprint 1 bearbeitet, da die Bearbeitung der Story keinen Mehraufwand darstellte und auch zur Grundstruktur passte.

Somit sah der Releasplan für die Sprints 1 und 2 wie folgt aus:
| **Sprint 1** |   **Sprint 2**  |
|--------------|-----------------|
| 1. Programm starten | 2. Vokabeln zufällig auswählen |
| 3. Vokabeln anzeigen | 6. Übersetzung prüfen |
| 4. Übersetzung eingeben | 9. Erfolgsquote |
| 5. Eingabe bestätigen | 10. Thema wählen |
| 7. Korrekte Übersetzung anzeigen |  |
| **8. Programm beenden** |  |
| 14. Initialisierung |  |

Die neue Velocity von Sprint 1 beträgt somit 18 Story Points und die von Sprint 2 14 Story Points.

<a name="dokumentationSprint2"/>

## 9. Dokumentation Sprint 2
### i. Taskliste für die Umsetzung der User Story
#### User Story 2 - Vokabeln zufällig auswählen (35')
| **Task** |   **Beschreibung**  |  **Aufwandschätzung** |
|:--------:|:--------------------|:---------------------:|
| 1 | Eine Zufallszahl ermitteln, abhängig von der Anzahl der in der eingelesenen Textdatei vorhandenen Vokabeln | 20' |
| 2 | Die Vokabeln auf einem String-Array “vokabeln” speichern | 15' |

#### User Story 6 - Überseztung prüfen (1h)
| **Task** |   **Beschreibung**  |  **Aufwandschätzung** |
|:--------:|:--------------------|:---------------------:|
| 1 | Übersetzung aus der Textdatei einlesen und auf einem String-Array “uebersetzung” speichern | 15' |
| 2 | Prüfen, ob die Variablen “eingabe” und “uebersetzung” an der Stelle der zufallszahl gleich sind mit der Equals-Methode | 20' |
| 3 | Label erstellen | 15' |
| 4 | Auf dem Label ausgeben, ob die Eingabe richtig oder falsch war | 10' |

#### User Story 9 - Überseztung prüfen (1h 10')
| **Task** |   **Beschreibung**  |  **Aufwandschätzung** |
|:--------:|:--------------------|:---------------------:|
| 1 | Integer-Variable “countKorrekt” erstellen und auf 0 setzen | 5' |
| 2 | Den auf der Variable “countKorrekt” gespeicherten Wert bei jeder richtigen Antwort um 1 erhöhen | 10' |
| 3 | Integer-Variable “countGesamt” erstellen und auf 0 setzen | 5' |
| 4 | Den auf der Variable “countGesamt” gespeicherten Wert bei jeder richtigen und falschen Antwort um 1 erhöhen | 10' |
| 5 | Double-Variable “erfolgsquote” erstellen | 5' |
| 6 | Erfolgsquote in Prozent berechnen und auf der Variable “erfolgsquote” speichern | 10' |
| 7 | Label erstellen | 15' |
| 8 | Die auf den Variablen “countKorrekt”, “countGesamt” und “erfolgsquote” gespeicherten Werte auf dem Label ausgeben | 10' |

#### User Story 10 - Thema wählen (3h 5')
| **Task** |   **Beschreibung**  |  **Aufwandschätzung** |
|:--------:|:--------------------|:---------------------:|
| 1 | Neue Textdateien schreiben | 1h 30' |
| 2 | Die neuen Textdateien einlesen können | 20' |
| 3 | So viele Buttons wie Textdateien erstellen / Dropdown-Menu erstellen | 30' |
| 4 | Je nach gewähltem Thema zugehörige Textdatei einlesen | 20' |
| 5 | Label erstellen | 15' |
| 6 | Das gewählte Thema auf dem Label ausgeben | 10' |

#### User Story 13 - Wiederholen schwieriger Vokabeln (1h 5')
| **Task** |   **Beschreibung**  |  **Aufwandschätzung** |
|:--------:|:--------------------|:---------------------:|
| 1 | do-while-Schleife erstellen | 25' |
| 2 | Array vom Typ boolean erstellen für jede Vokabel | 15' |
| 3 | do-while-Schleife erst beenden, wenn alle Vokabeln als richtig abgespeichert wurden | 10' |
| 4 | Nur Vokabeln abfragen, die als falsch abgespeichert sind | 15' |

### ii. Erfahrungen und Anpassungen
Bereits während der Arbeit am ersten Sprint ist klar geworden, dass es nicht möglich ist, immer jede Story für sich starr abzuarbeiten. Häufig kommt es vor, dass es während der Erarbeitung eines Tasks aus einer Story Sinn macht, auch gleich einen Task einer anderen Story zu bearbeiten, da es einfach zum Workflow passt.
Deshalb wurde die User Story 13 vorgezogen und bereits im Sprint 2 bearbeitet.

Durch unsere neuen Erfahrungen mit der Objektorientierten Programmierung konnten wir gewisse Aufgaben anders lösen, als wir das noch vor einem halben Jahr getan hätten. So haben wir beispielsweise für die User Story 13 weder boolean für die Vokabeln erstellt, noch haben wir eine do-while-Schleife verwendet. Stattdessen haben wir zwei verschiedene, variable Listen mit den noch zu lernenden Vokabeln und den falsch übersetzten Vokabeln erstellt. Auf ähnliche Weise wurden weitere Tasks während der Umsetzung leicht angepasst.

Somit sah der Releasplan wie folgt aus:
| **Sprint 1** |   **Sprint 2**  |   **Sprint 3**  |
|--------------|-----------------|-----------------|
| 1. Programm starten | 2. Vokabeln zufällig auswählen | 11. Sprache wählen |
| 3. Vokabeln anzeigen | 6. Übersetzung prüfen | 12. Übersetzungsrichtung wählen |
| 4. Übersetzung eingeben | 9. Erfolgsquote |  |
| 5. Eingabe bestätigen | 10. Thema wählen |  |
| 7. Korrekte Übersetzung anzeigen | **13. Wiederholen schwieriger Vokabeln** | |
| **8. Programm beenden** |  |  |
| 14. Initialisierung |  |  |

<a name="dokumentationSprint3"/>

## 10. Dokumentation Sprint 3
### i. Taskliste für die Umsetzung der User Story
#### User Story 11 - Sprache wählen (3h 5')
| **Task** |   **Beschreibung**  |  **Aufwandschätzung** |
|:--------:|:--------------------|:---------------------:|
| 1 | Neue Textdateien schreiben | 1h 30' |
| 2 | Die neuen Textdateien einlesen können | 20' |
| 3 | So viele Buttons wie Sprachen erstellen / Dropdown-Menu erstellen | 30' |
| 4 | Je nach gewählter Sprache zugehörige Textdatei einlesen | 20' |
| 5 | Label erstellen | 15' |
| 6 | Die gewählte Sprache auf dem Label ausgeben | 10' |

#### User Story 12 - Übersetzungsrichtung wählen (1h 10')
| **Task** |   **Beschreibung**  |  **Aufwandschätzung** |
|:--------:|:--------------------|:---------------------:|
| 1 | Zwei Buttons erstellen / Dropdown-Menu | 30' |
| 2 | Label erstellen | 15' |
| 3 | Die gewählte Übersetzungsrichtung auf dem Label ausgeben | 10' |
| 4 | Je nach gewählter Übersetzungsrichtung, die auf den Variablen “vokabel” und “uebersetzung” gespeicherten Strings miteinander vertauschen | 15' |

### ii. Erfahrungen und Anpassungen
Während der Arbeit ist klar geworden, dass eine gewisse Flexibilität unentbehrlich ist. In Sprint 1 und 2 haben wir Storys vorgezogen, da es besser zum Workflow passte. Dies war dank Agilem Planning möglich.
Nach dem Implementieren der Model View Controller Struktur wurde der Programmcode um einiges vereinfacht und damit übersichtlicher. Dies half dabei, sich besser im Code zurechtzufinden. 
Aufgrund der vorgegangenen Änderungen, mussten in Sprint 3 nur noch zwei User Storys bearbeitet werden. Das war eine grosse Entlastung, da das Unit Testing sehr viel Zeit in Anspruch nahm.

Der entgültige Releaseplan sah somit wie folgt aus:
| **Sprint 1** |   **Sprint 2**  |   **Sprint 3**  |
|--------------|-----------------|-----------------|
| 1. Programm starten | 2. Vokabeln zufällig auswählen | 11. Sprache wählen |
| 3. Vokabeln anzeigen | 6. Übersetzung prüfen | 12. Übersetzungsrichtung wählen |
| 4. Übersetzung eingeben | 9. Erfolgsquote | **Umstrukturierung zu MVC** |
| 5. Eingabe bestätigen | 10. Thema wählen | **UnitTesting** |
| 7. Korrekte Übersetzung anzeigen | **13. Wiederholen schwieriger Vokabeln** | |
| **8. Programm beenden** |  |  |
| 14. Initialisierung |  |  |

<a name="snippets"/>

## 11. Dokumentation wichtiger Code Snippets
Der erste Code Snippet zeigt einen Teil der Umsetzung von User Storys 5 und 9. Er ist in der Klasse 'TrainingsController' zu finden.
In dieser Methode wird zunächts geprüft ob die Eingabe ins Textfeld gültig ist. Im Weiteren wird geprüft ob die eingegeben Übersetzung im Textfeld korrekt ist. Falls die Übersetzung richtig ist, wird die Methode 'antwortAnzeigen()' der Klasse 'View' aufgerufen und die richtige Übersetzung angezeigt. Zusätzlich wird die Klasse 'VokabelModel' aktualisiert. Der Zähler der korrekten und gesamten Vokabeln wird aktualisiert, um später die Erfolgsquote berechnen zu können.

	private void bestaetigen(String eingabe) {
		// Die Eingabe ist ungültig, wenn das Textfeld leer ist oder nur aus Sonderzeichen besteht.
		if (!eingabe.matches(".*[a-zA-Z].*")) {
			view.eingabeUngueltig();	
			return;
		}
		
		// Es wird geprüft, ob die eingegebene Übersetzung richtig ist.
		boolean richtig = eingabe.trim().equals(model.getAktuelleVokabeln().get(model.getIndex()).getUebersetzung());
		view.antwortAnzeigen(richtig);
		
		List<Vokabel> aktuell = model.getAktuelleVokabeln(), falsch = model.getFalscheVokabeln();
		
		if(richtig) model.setCountKorrekt(model.getCountKorrekt() + 1);
		else falsch.add(aktuell.get(model.getIndex()));
		
		model.setCountGesamt(model.getCountGesamt() + 1);
		model.setIndex(model.getIndex() + 1);
	}

\
Dieser Code Snippet zeigt einen Teil der Umsetzung von User Storys 10 und 11. Er ist im Enum 'Themen' zu finden.
Das Enum 'Thema' wurde erstellt, um die Themen und Sprachen den Textfiles zuzuordnen. Dies dient dazu, nicht zu jedem Textfile den ganzen Pfad eingeben zu müssen. Diese Funktion übernimmt die Methode 'getFilePath()'.

	// Je nach gewähltem Thema werden die Vokabeln aus einer anderen Textdatei genommen.
	Tiere("Animaux", "Animals"), Berufe("Professions-et-bureau", "Professions-and-office"),
	Tourismus("Tourisme-et-transport", "Tourism-and-transport");

	private final String fr, en;
	
	// Je nach gewählter Sprache werden die Vokabeln aus einer anderen Textdatei genommen.
	private Thema(String fr, String en) {	
		this.fr = getFilePath(fr);
		this.en = getFilePath(en);
	}

	private static String getFilePath(String name) {
		return "/com/vokabeltrainer/" + name + ".txt";
	}

\
Dieser Code Snippet ist in der Klasse 'TrainingsView' zu finden. Er representiert unter anderem einen Teil der User Story 3, sowie der User Storys 7 und 12.
'nextVokabel()' entfernt die vorhergegangenen Anzeigen und Eingaben und bereitet den Bildschirm für die nächste Vokabel vor. Dies wird mit Hilfe von entfernen bzw. anzeigen von verschiedener Buttons und Texten erreicht. Anschliessend wird direkt auch die nächste Vokabel angezeigt, dazu muss die Sprache mit der Methode 'isRichtungUmkehren()' aus der Klasse 'VokabelModel' ermittelt werden.

	public void nextVokabel() {
		antwort.clear();
		antwort.setDisable(false);
		loesung.setText(null);
		gepruefteEingabe.setText(null);
		bestaetigenButton.setDisable(false);
		weiterButton.setVisible(false);
		endeButton.setVisible(false);
		
		String sprache = model.isRichtungUmkehren() ? "Deutsch" : model.getSprache(); 
		frage.setText("Was heißt '" + model.getAktuelleVokabeln().get(model.getIndex()).getVokabel() + "' auf " + sprache + "?");
	}

\
Mit Hilfe dieses Code Snippets werden Drop Down Menüs erstellt. Die Methode befindet sich in der Klasse 'StartView' und wird für die User Storys 10, 11 und 12 jeweils einmal aufgerufen. Zunächst wird die Funktion des Drop Down Menüs festgelegt, bevor es formatiert wird.

	protected ComboBox<String> createComboBox(String id, String prompt, List<String> items, Runnable event) {
		ComboBox<String> drop = new ComboBox<String>(FXCollections.observableList(items));
		drop.setId(id);
		drop.setPromptText(prompt);
		drop.setOnAction(action -> event.run());
		drop.setMinWidth(250);
		drop.setMinHeight(50);
		drop.setStyle("-fx-background-color: #D3d3d3; -fx-font-size: 1.3em; -fx-border-color: #FFFFFF; -fx-border-width: 2px");
		return drop;
	}
