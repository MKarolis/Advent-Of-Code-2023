println('EX 2')

int result = 0

def is = new File("src/input1.txt").newInputStream()
is.eachLine(line -> {
    String id = (line =~ /Game (\d+)/)[0][1]
    def sanitizedLine = line.replaceAll(/Game \d+:/, "")

    int maxRed = 0
    int maxGreen = 0
    int maxBlue = 0

    sanitizedLine.split(";").each {
        def gotRed = (it =~ /(\d+) red/)
        if (gotRed.size() > 0 && gotRed[0][1].toInteger() > maxRed) maxRed = gotRed[0][1].toInteger();

        def gotGreen = (it =~ /(\d+) green/)
        if (gotGreen.size() > 0 && gotGreen[0][1].toInteger() > maxGreen) maxGreen = gotGreen[0][1].toInteger();

        def gotBlue = (it =~ /(\d+) blue/)
        if (gotBlue.size() > 0 && gotBlue[0][1].toInteger() > maxBlue) maxBlue = gotBlue[0][1].toInteger();
    }

    result += (maxRed * maxGreen * maxBlue)

    println(String.format("%s || %s || %s, %s, %s", id, sanitizedLine, maxRed, maxGreen, maxBlue))
})
is.close()

println(result)
