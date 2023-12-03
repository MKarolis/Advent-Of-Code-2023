int RED = 12
int GREEN = 13
int BLUE = 14

int result = 0

def is = new File("src/input1.txt").newInputStream()
is.eachLine(line -> {
    String id = (line =~ /Game (\d+)/)[0][1]
    def sanitizedLine = line.replaceAll(/Game \d+:/, "")

    boolean valid = true

    sanitizedLine.split(";").each {
        def gotRed = (it =~ /(\d+) red/)
        if (gotRed.size() > 0 && gotRed[0][1].toInteger() > RED) valid = false;

        def gotGreen = (it =~ /(\d+) green/)
        if (gotGreen.size() > 0 && gotGreen[0][1].toInteger() > GREEN) valid = false;

        def gotBlue = (it =~ /(\d+) blue/)
        if (gotBlue.size() > 0 && gotBlue[0][1].toInteger() > BLUE) valid = false;
    }

    if (valid) {
        result += id.toInteger()
    }

    println(String.format("%s || %s || %s", id, sanitizedLine, valid))
})
is.close()

println(result)
