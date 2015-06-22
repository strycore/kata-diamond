public class Diamond {
    public String buildFor(String character) {
        int initialDistance = initialDistanceToA(character);
        return iterate(initialDistance, initialDistance);
    }

    private int initialDistanceToA(String character) {
        return character.charAt(0) - 'A';
    }

    private String iterate(int distanceToA, int initialDistanceToA) {
        String result = "";
        String charAfterA = charAfterA(initialDistanceToA - distanceToA);
        if (distanceToA > 0) {
            result += addLine(distanceToA, charAfterA);
            result += iterate(distanceToA - 1, initialDistanceToA);
        }
        return result + addLine(distanceToA, charAfterA);
    }

    private String charAfterA(int distance) {
        return Character.toString((char) ('A' + distance));
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
        return result + "\n";
    }
}
