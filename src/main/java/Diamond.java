public class Diamond {
    public String buildFor(String character) {
        char a = 'A';
        int initialDistance = character.charAt(0) - a;
        return doTheJob(initialDistance);
    }

    private String doTheJob(int initialDistance) {
        return doTheJob(initialDistance, initialDistance);
    }

    private String doTheJob(int distance, int distanceInitiale) {
        String result = "";
        if (distance > 0) {
            result += addLine(distance, Character.toString((char) ('A' + (distanceInitiale - distance))));
            result += doTheJob(distance - 1, distanceInitiale);
        }
        result += addLine(distance, Character.toString((char) ('A' + (distanceInitiale - distance))));
        return result;
    }

    private String addLine(int newDistance, String currentCharacter) {
        String result = "";
        for (int i = 0; i < newDistance; i++) {
            result += " ";
        }
        result += currentCharacter;
        if (currentCharacter.charAt(0) - 'A' > 0) {
            for (int i = 0; i < (currentCharacter.charAt(0) - 'A' - 1) * 2 + 1; i++) {
                result += " ";
            }
            result += currentCharacter;
        }
        result += "\n";
        return result;
    }
}
