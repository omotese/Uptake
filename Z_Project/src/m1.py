"""
The Python Capstone Project.

CSSE 120 - Introduction to Software Development.
Team members: Chase Horne Oyenbhen Omotese Jacob Pluta Dakota Jassmin Rostron.

The primary author of this module is: Chase Horne
"""
# done: Put the names of ALL team members in the above where indicated.
#       Put YOUR NAME in the above where indicated.

import m0
import m2
import m3
import m4

import tkinter
from tkinter import ttk
import rosebot as rb



def my_frame(root, dc):
    print('m1', dc)
    """
    Constructs and returns a   ttk.Frame   on the given root window.
    The frame contains all of this module's widgets.
    Does NOT   grid   the Frame, since the caller will do that.
    Also sets up callbacks for this module's widgets.

    The first argument is the  root  window (a tkinter.Tk object)
    onto which the   ttk.Frame  returned from this function
    will be placed.  The second argument is the shared DataContainer
    object that is CONSTRUCTED in m0 but USED in m1, m2, m3 and m4.

    Preconditions:
      :type root: tkinter.Tk
      :type dc:   m0.DataContainer
    """
    # creates my frame with label
    frame = ttk.Frame(root, padding=10, relief='ridge')

    label = ttk.Label(frame, text='Chase Horne')
    label.grid()


    # button for main window
    main_button = ttk.Button(frame, text='main window')
    main_button.grid()
    main_button['command'] = (lambda: main_window(dc))

    return frame


def main_window(dc):
    # create window, frame and menu
    root = tkinter.Tk()

    root.option_add('*tearOff', False)

    menubar = tkinter.Menu(root)
    root['menu'] = menubar

    frame = ttk.Frame(root, padding=20, relief='ridge')
    frame.grid()

    # connect to robot
    connect_entry_box = ttk.Entry(frame)
    connect_entry_box.grid()

    connect_button = ttk.Button(frame, text='connect wireless')
    connect_button.grid()
    connect_button['command'] = (lambda: connect_wireless(connect_entry_box, dc))

    connect_button = ttk.Button(frame, text='connect wired')
    connect_button.grid()
    connect_button['command'] = (lambda: connect_wired(dc))

    # control menu and its options
    control_menu = tkinter.Menu(menubar)
    menubar.add_cascade(menu=control_menu, label='contols')

    control_menu.add_command(label='key operated',
                            command=lambda:key_switch(dc))

    control_menu.add_command(label='secret message',
                            command=lambda: morse_window(dc))


    # key operated movement

    speed_box = ttk.Entry(frame)
    speed_box.grid()
    speed_label = ttk.Label(frame, text='Enter Speed: (0 - 200)')
    speed_label.grid()

    dc.speed = speed_box

    turn_box = ttk.Entry(frame)
    turn_box.grid()
    angle_label = ttk.Label(frame, text='Enter Turn Angle: (1 - 360)')
    angle_label.grid()

    dc.turn_speed = turn_box

    root.bind_all('<Key-Up>',
                  lambda event: key_forward(dc))
    root.bind_all('<Key-Down>',
                  lambda event: key_backward(dc))
    root.bind_all('<Key-Right>',
                  lambda event: key_right(dc))
    root.bind_all('<Key-Left>',
                  lambda event: key_left(dc))
    root.bind_all('<Key-Shift_R>',
                  lambda event: key_stop(dc))

# ----------------------------------------------------------------------
# If this module is running at the top level (as opposed to being
# imported by another module), then call the 'main' function.
# ----------------------------------------------------------------------

def morse_window(dc):
    # window for morse messages
    root = tkinter.Tk()

    frame = ttk.Frame(root, padding=20, relief='ridge')
    frame.grid()

    morse_label = ttk.Label(frame, text='Enter your message now')
    morse_label.grid()

    morse_entry_box = ttk.Entry(frame)
    morse_entry_box.grid()

    morse_button = ttk.Button(frame, text='Beep the message')
    morse_button.grid()
    morse_button['command'] = (lambda: morse_message(dc, morse_entry_box))



def morse_message(dc, entry_box):
    # takes message and has robot beep it in morse
    message = entry_box.get()
    message = message.lower()
    for k in range(len(message)):
        letter = dc.dictionary[message[k]]
        for i in range(len(letter)):
            morse_buzz(dc, letter[i])
            dc.robot.connection.sleep(dc.length_of_dot * 2)


def morse_buzz(dc, dot_dash_or_space):
    # makes the morse beep with buzzer depending on whats sent
    length = dc.length_of_dot

    if dot_dash_or_space == '.':
        dc.robot.buzzer.play_tone(550)
        dc.robot.connection.sleep(length)
        dc.robot.buzzer.stop()
        dc.robot.connection.sleep(length)
    elif dot_dash_or_space == '-':
        dc.robot.buzzer.play_tone(550)
        dc.robot.connection.sleep(length * 3)
        dc.robot.buzzer.stop()
        dc.robot.connection.sleep(length)
    elif dot_dash_or_space == '/':
        dc.robot.connection.sleep(length * 4)


def morse_dictionary(dc):
    # makes morse code dicitonary
    dictionary = open('morse.txt', 'r')
    for line in dictionary:
        dc.dictionary[line[0]] = line[1:]


def connect_wireless(entry_box, dc):

    wifly_number = int(entry_box.get())

    dc.robot.connect_wifly(wifly_number)


def connect_wired(dc):
    dc.robot.connect_wired()


def placeholder():
    print('does nothing')


def key_switch(dc):
    # turns on or off keyswitch
    if dc.key:
        dc.key = False
    else:
        dc.key = True


def key_forward(dc):
    if dc.key:
        m3.forward(dc, dc.speed)


def key_backward(dc):
    if dc.key:
        m3.backward(dc, dc.speed)


def key_left(dc):
    if dc.key:
        m3.left(dc, dc.speed, dc.turn_speed)


def key_right(dc):
    if dc.key:
        m3.right(dc, dc.speed, dc.turn_speed)

def key_stop(dc):
    if dc.key:
        dc.robot.differential_drive.stop()

if __name__ == '__main__':
    m0.main()
