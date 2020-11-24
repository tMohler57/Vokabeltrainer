# Vokabeltrainer

Programmieren II / Software Engineering Projekt

#### Mitglieder: 
Isabelle Dittmann: SCRUM Master / Entwickler

Karolina Schmidt: Oberflächen Designer / Entwickler

Morgan Farnworth: Software Architect / Entwickler

Tanja Mohler: Product Owner / Entwicker

## Inhaltsverzeichnis

1. [Einleitung](#einleitung)
1. [Build-Anleitung](#build-anleitung)
1. [Kurze Bedienungsanleitung](#bedienungsanleitung)
1. [Userstories](#userstories)
1. [Releaseplan](#releaseplan)

## 1. Einleitung
Bei unserem Projekt handelt es sich um einen Vokabeltrainer. Der Nutzer möchte Vokabeln lernen, ohne den Hintergrund der Programmierung zu kennen. Er nutzt nur das ihm zur Verfügung gestellte Interface. Ihm ist wichtig, dass das Programm einfach zu bedienen ist.

Ziel dieses Projektes ist es, dass der Nutzer seinen Wortschatz verbessern kann, in dem er sich in der Übersetzung der von uns vorgeschlagenen Vokabeln übt.

#### Randbedingungen:
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

## 4. Userstories
| **Titel** |   **Userstories**  |  **Priorität** | **Storypoints** | **Akzeptanzkriterien** |
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
| 14. Initialisierung | 2. Vokabeln zufällig auswählen | 11. Sprache wählen |  
| 1. Programm starten | 8. Programm beenden | 12. Übersetzungsrichtung wählen |
| 3. Vokabeln anzeigen | 6. Übersetzung prüfen | 13. Wiederholen schwieriger Vokablen |
| 4. Übersetzung eingeben | 9. Erfolgsquote |  |
| 5. Eingabe bestätigen | 10. Thema wählen |  |
| 7. Korrekte Übersetzung anzeigen |  |  |

Velocity von 16 Storypoints pro Sprint
