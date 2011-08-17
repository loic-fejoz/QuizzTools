# QuizzTools #

QuizzTools is a set of tools to create and pass quizz. It is mainly an Eclipse Editor and HTML exporter.
The editor can read file in his own XMI format or in the GIFT (Moodle) format.

The License is [EPL](http://www.eclipse.org/legal/epl-v10.html "Eclipse Public License").

## Documentation ##
### Eclipse Editor ###
All files with extension .gift and .quizz are associated with the QuizzTools editor. Just double-clic them to open them.

#### Creation ####
To create a new quizz, go to "File"/"New"/"Example EMF Model Creation Wizards"/"Quizz Model", then choose Quizz as the model root.
Use the properties tab to modify it, and use the contextual menu to add Questions and Answers.

#### Conversion ####
Right-clic the file and choose a command in the Quizz submenu.
Or use the File/Export menu to export a quizz to GIFT format.
Or in the editor, right-clic the Quizz object and choose Quizz/"Export to gift".

### Format ###
#### GIFT ####
GIFT is a textual format defined by the Moodle project. File extension is .gift.
See  http://docs.moodle.org/fr/Format_GIFT

#### Ecore/XMI ####
The editor is based on his own [Quizz Ecore model](https://github.com/loic-fejoz/QuizzTools/blob/master/quizz-plugin/model/quizz.ecore). Thus it has a default XMI serialization. File extension is .quizz.


## Quizz ##
 * Sample quizz can be found on [quizz-html-exporter/test](https://github.com/loic-fejoz/QuizzTools/tree/master/quizz-html-exporter/test).
