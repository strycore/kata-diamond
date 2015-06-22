def get_offset_of_char(char):
    return ord(char) - ord('A')


def draw_line(distance, char):
    result = " " * distance + char
    if get_offset_of_char(char):
        result += " " * ((get_offset_of_char(char) - 1) * 2 + 1) + char
    return result + "\n"


def diamond(base_char, distance=None):
    initial_distance = get_offset_of_char(base_char)
    if initial_distance < 0:
        raise ValueError('Invalid character %s' % base_char)
    if distance is None:
        distance = initial_distance
    result = ""
    char = chr(ord('A') + initial_distance - distance)
    if distance:
        result += draw_line(distance, char)
        result += diamond(base_char, distance - 1)
    return result + draw_line(distance, char)


assert(diamond('A') == "A\n")
assert(diamond('B') == " A\nB B\n A\n")
assert(diamond('C') == "  A\n B B\nC   C\n B B\n  A\n")
assert(diamond('D') == "   A\n  B B\n C   C\nD     D\n C   C\n  B B\n   A\n")
