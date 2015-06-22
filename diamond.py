"""Diamond kata: print a diamond shape in ASCII."""


def get_offset_of_char(char):
    """Return distance between `char` and A."""
    return ord(char) - ord('A')


def draw_line(char, distance):
    """Return a line of the diamond drawing."""
    result = " " * distance + char
    if get_offset_of_char(char):
        result += " " * ((get_offset_of_char(char) - 1) * 2 + 1) + char
    return result + "\n"


def diamond(base_char, distance=None):
    """Build the diamond."""
    initial_distance = get_offset_of_char(base_char)
    if initial_distance < 0:
        raise ValueError('Invalid character %s' % base_char)
    if distance is None:
        distance = initial_distance
    result = ""
    char = chr(ord('A') + initial_distance - distance)
    if distance:
        result += draw_line(char, distance)
        result += diamond(base_char, distance - 1)
    return result + draw_line(char, distance)


assert diamond('A') == "A\n"
assert diamond('B') == " A\nB B\n A\n"
assert diamond('C') == "  A\n B B\nC   C\n B B\n  A\n"
assert diamond('D') == "   A\n  B B\n C   C\nD     D\n C   C\n  B B\n   A\n"
