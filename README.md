# Vokabeltrainer

Programmieren II / Software Engineering Projekt

#### Mitglieder: 
Isabelle Dittmann: SCRUM Master / Entwickler

Karolina Schmidt: Oberflächen Designer / Entwickler

Morgan Farnworth: Software Architect / Entwickler

Tanja Mohler: Product Ownder / Entwicker

## Inhaltsverzeichnis

1. [Einleitung](#einleitung)
   1. [Ziele](#ziele)
   1. [Randbedingungen](#randbedingungen)
1. [Build-Anleitung](#build-anleitung)
1. [Kurze Bedienungsanleitung](#bedienungsanleitung)
1. [User Stories](#userstories)
1. [Releaseplan mit den Ausbaustufen](#releaseplan)
1. [Dokumentation Sprint 1](#dokumentationSprint1)
   1. [Taskliste für die Umsetzung der User Story](#taskliste)
   1. [UML Package, Klassen- und Sequenzdiagramm](#klassendiagramm)
   1. [Dokumentation wichtiger Code Snippets](#snippets)
   1. [Herleitung der Testfälle aus den Akzeptanzkriterien der User Stories](#testfälle)
   1. [Erfahrungen und Anpassungen](#zusammenfassung)
1. [Dokumentation Sprint 2](#dokumentationSprint2)
   1. [Taskliste für die Umsetzung der User Story](#taskliste)
   1. [UML Package, Klassen- und Sequenzdiagramm](#klassendiagramm)
   1. [Dokumentation wichtiger Code Snippets](#snippets)
   1. [Herleitung der Testfälle aus den Akzeptanzkriterien der User Stories](#testfälle)
   1. [Erfahrungen und Anpassungen](#zusammenfassung)
1. [Dokumentation Sprint 3](#dokumentationSprint3)
   1. [Taskliste für die Umsetzung der User Story](#taskliste)
   1. [UML Package, Klassen- und Sequenzdiagramm](#klassendiagramm)
   1. [Dokumentation wichtiger Code Snippets](#snippets)
   1. [Herleitung der Testfälle aus den Akzeptanzkriterien der User Stories](#testfälle)
   1. [Erfahrungen und Anpassungen](#zusammenfassung)

## 1. Einleitung
Bei unserem Projekt handelt es sich um einen Vokabeltrainer. Der Nutzer möchte Vokabeln lernen, ohne den Hintergrund der Programmierung zu kennen. Er nutzt nur das ihm zur Verfügung gestellte Interface. Ihm ist wichtig, dass das Programm einfach zu bedienen ist.

### i. Ziele
Ziel dieses Projektes ist es, dass der Nutzer seinen Wortschatz verbessern kann, in dem er sich in der Übersetzung der von uns vorgeschlagenen Vokabeln übt.

### ii. Randbedingungen:
- Die Programmierung der Anwendung erfolgt in Java.
- Das Projekt ist auf GitHub öffentlich einsehbar.
- Das Projekt wurde getestet.
- Das Projekt wurde mit dem Git-Workflow Vincent Driessen erstellt.
- Die Build-Automatisierung erfolgt mittels Maven.
- Das Projekt wurde mit der SCRUM Methode durchgeführt. Dies beinhaltet Userstories und einen Releaseplan.


## 2. Build-Anleitung
Buildanleitung unabhängig vom Betriebssystem:
- Sie benötigen eine Java Umgebung auf ihrem Computer.
- Die .java-Dateien können per Doppelklick geöffnet werden.
- Zum Starten der Benutzeroberfläche muss die Datei Launcher.java ausgeführt werden.


## 3. Kurze Bedienungsanleitung


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


## 6. Dokumentation Sprint 1
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
| 1 | Prüfen, ob Eingabe erlaut ist | 25' |
| 2 | Label erstellen | 15' |
| 3 | Auf dem Label eine Fehlermeldung ausgeben, falls die Eingabe nicht erlaubt ist | 10' |
| 4 | Ins Textfeld eingegebenen Text einlesen und auf einer String-Variable “eingabe” speichern | 10' |
| 5 | Button erstellen | 15' |
| 6 | Action Handler programmieren | 30' |

#### User Story 7 - Korrekte Übersetzung anzeigen (25')
| **Task** |   **Beschreibung**  |  **Aufwandschätzung** |
|:--------:|:--------------------|:---------------------:|
| 1 | Label erstellen | 15' |
| 2 | Auf dem Label die passende Variable "uebersetzung ausgeben | 10' |

#### User Story 8 - Programm beenden (45')
| **Task** |   **Beschreibung**  |  **Aufwandschätzung** |
|:--------:|:--------------------|:---------------------:|
| 1 | Button erstellen | 15' |
| 2 | Action Handler programmieren | 30' |

Diese Story wurde aus Sprint 2 übernommen. Siehe Kapitel vi.

#### User Story 14 -Initialisierung (3h 50')
| **Task** |   **Beschreibung**  |  **Aufwandschätzung** |
|:--------:|:--------------------|:---------------------:|
| 1 | Grundstruktur des Programms erstellen (z.B. Klassen, Unterklassen, Main-Methode, usw.) | 2h |
| 2 | layout des Programmfensters erstellen | 1h |
| 3 | Erste Textdatei schreiben | 30' |
| 4 | Textdatei einlesen | 20' |

### ii. UML Package, Klassen- und Sequenzdiagramm
### iii. Dokumentation wichtiger Code Snippets
### iv. Herleitung der Testfälle aus den Akzeptanzkriterien der User Stories
### v. Erfahrungen und Anpassungen
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

## 7. Dokumentation Sprint 2
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
| 2 | Array vom Typ boolean erstellen und zu jeder Vokabel | 15' |
| 3 | do-while-Schleife erst beenden, wenn alle Vokabeln als richtig abgespeichert wurden | 10' |
| 4 | Nur Vokabeln abfragen, die als falsch abgespeichert sind | 15' |

### ii. UML Package, Klassen- und Sequenzdiagramm
### iii. Dokumentation wichtiger Code Snippets
### iv. Herleitung der Testfälle aus den Akzeptanzkriterien der User Stories
### v. Erfahrungen und Anpassungen
Während der Bearbeitung des zweiten Sprints wurde die User Story 13 aus Sprint 3 vorgezogen und ebenfalls erledigt.

Somit sah der Releasplan wie folgt aus:
| **Sprint 1** |   **Sprint 2**  |   **Sprint 3**  |
|--------------|-----------------|-----------------|
| 1. Programm starten | 2. Vokabeln zufällig auswählen | 11. Sprache wählen |
| 3. Vokabeln anzeigen | 6. Übersetzung prüfen | 12. Übersetzungsrihtung wählen |
| 4. Übersetzung eingeben | 9. Erfolgsquote |  |
| 5. Eingabe bestätigen | 10. Thema wählen |  |
| 7. Korrekte Übersetzung anzeigen | **13. Wiederholen schwieriger Vokabeln** | |
| **8. Programm beenden** |  |  |
| 14. Initialisierung |  |  |

## 8. Dokumentation Sprint 3
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

### ii. UML Package, Klassen- und Sequenzdiagramm
### iii. Dokumentation wichtiger Code Snippets
### iv. Herleitung der Testfälle aus den Akzeptanzkriterien der User Stories
### v. Erfahrungen und Anpassungen
