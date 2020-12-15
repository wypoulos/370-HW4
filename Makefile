JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	ProducerConsumer.java\
	Consumer.java\
	Producer.java\
	Buffer.java

all:	classes

default:	classes

classes:	$(CLASSES:.java=.class)

clean:
	$(RM) *.class