Examtester: Examtester.java
		javac Examtester.java
Exam: Exam.java Examtester.java
		javac Exam.java Examtester.java
Question: Exam.java Question.java Examtester.java
		javac Exam.java Question.java Examtester.java
Answer: Exam.java Question.java Answer.java Examtester.java
		javac Exam.java Question.java Answer.java Examtester.java
QPanel.class : Qpanel.java
		javac QPanel.java
SAPanel.class : SAPanel.java QPanel.class
		javac SAPanel.java
NumPanel.class : NumPanel.java QPanel.class
		javac NumPanel.java
MCSAPanel.class : MCSAPanel.java QPanel.class
		javac MCSAPanel.java
MCMAPanel.class : MCMAPanel.java QPanel.class
		javac MCMAPanel.java
ExamBuilderGUI.class : ExamBuilderGUI.java QPanel.class SAPanel.class NumPanel.class MCSAPanel.class MCMAPanel.class
		javac ExamBuilderGUI.java