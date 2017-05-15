# Tagebuch von Christoph

Ich fasse hier mal zusammen was ich bisher so gemacht habe.
Damit können wir uns später besser einen Überblick verschaffen und gegebenfalls eine Timeline erstellen.


## Twitter Client
 
- **27.04**: Erste Erstellung eines lauffähigen Prototypens welcher sich auf die Twitter Streaming API verbindet und Tweets empfängt
- **08.05**: Consumer können sich jetzt auf mit dem Twitter Client verbinden und auf auftretende Tweets reagieren
- **08.05**: Implementierung eines MongoDB Consumers, mit MongoDB lassen sich einfach JSON Objekte speichern und bei bedarf durchsuchen. Die Twitter API sendet Tweets im JSON Format, von daher erweist sich MongoDB als idealer initialer Datenspeicher.
- **14.05**: Implementierung für den Locationfilter
- **14.05**: Erstellung eines Shellscripts um den Twitter Client auf dem Server im Hintergrund laufen zu lassen 

## Server

- **14.05**: Upload des Twitter Clients auf den Server um einen Testlauf zu starten (Tweets in Berlin)

## Recherche

- **27.04**: Wo bekommen wir die Daten her?
- **27.04**: Twitter Streaming API streamt Tweets sobald Sie getweeted werden zu einem Client
- **27.04**: Entscheidung: Hosebird Client (hbc), weil offiziell von Twitter entwickelt
- **08.04**: Wie kann man Text analysieren? Ggf. NLP Techniken anwenden
- **11.04**: Testen der NLP Library http://www.spacy.io/
- **11.04**: Erfolreiche Extrahierung von ***Named Entities*** aus Tweets
- **14.05**: Interessante Studie, die ähnlich unserer ist: http://www.ling.uni-potsdam.de/~scheffler/twitter/
- **TODO**: Consumer sollten aktivierbar und deaktivierbar per config.yml sein


### Mögliche Themen, Unterthemen und Themen Inhalte

**15.04**:

- Explorative Studie über die Verwendung des deutschsprachigen Twitters
  - Erstellung eines Socialgraphen (Wer followed wem, wer ist mit wem verbunden)
  - Unterteilung der Gesprächsthemen in Kategorien wie z.B.: Politik, Tech, Musik, Prominente
  - Top Schlagwörter
  - Top Hashtags
  - Konnten besondere Ereignissen extrahiert werden
  - Sentiment Analyse Allgemein
  - Sentiment Analyse zu Schlagwort
  - Ggf. andere Analysen die uns so einfallen und Interessant sind
  - Tweets pro Tag
- Explorative Studie über die Verwendung von Twitter in Berlin (oder Deutschland, wenn das geht)
  - Erstellung eines Socialgraphen (Wer followed wem, wer ist mit wem verbunden)
  - Unterteilung der Gesprächsthemen in Kategorien wie z.B.: Politik, Tech, Musik, Prominente
  - Top Schlagwörter
  - Top Hashtags
  - Konnten besondere Ereignissen extrahiert werden
  - Sentiment Analyse Allgemein (ggf. über Zeit)
  - Sentiment Analyse zu Schlagwort
  - Welche Sprachen werden auf Twitter verwendet?
  - Ggf. andere Analysen die uns so einfallen und Interessant sind
  - Tweets pro Tag
- Explorative Studie über radikale Tweets auf Twitter
- Explorative Studie über den Zusammenhang zwischen Wetter und dem Tweetverhalten

#### Herausforderungen

- Sentitment Analyse: Aber wie?
- Socialgraph: Wie die Visialisierung und welche Daten sollen genau Visualisiert werden
- Gesprächsthemen: Auf welcher Basis kann man hier unterteilen?
- Besondere Ereignisse: Wie erkennt man so etwas?
