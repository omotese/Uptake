"""
The Python Capstone Project.

CSSE 120 - Introduction to Software Development.
Team members: Chase Horne, Joy (Oyenbhen Omotese), 
Jacob Pluta, and Dakota Rostron  (all of them).

The primary author of this module is: Dakota Rostron.
"""
# DONE: Put the names of ALL team members in the above where indicated.
#       Put YOUR NAME in the above where indicated.

import m0
import m1
import m2
import m3
import tweepy

import tkinter
from tkinter import ttk
import rosebot as rb

# Class for Pen----------------------------------------------------------------------

class Pen_Data():
    def __init__(self):
        self.color = 'black'
        self.shape = 'none'
        self.width = 3
        self.mouse_position_x = None
        self.mouse_position_y = None
        self.is_dragging = False


def my_frame(root, dc):
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

# Initialize----------------------------------------------------------------------
    frame = ttk.Frame(root, padding=10, relief='ridge')
    name_label = ttk.Label(frame, text='Dakota Rostron')
    name_label.grid()

# Connect to Robot----------------------------------------------------------------------
    connect_label = ttk.Label(frame, text='Enter Robot Number for Connection!')
    connect_label.grid()

    connect_entry_box = ttk.Entry(frame)
    connect_entry_box.grid()

    connect_button = ttk.Button(frame, text='Connect to robot')
    connect_button.grid()
    connect_button['command'] = (lambda: connect_to_robot(connect_entry_box, dc))

# Remote Control----------------------------------------------------------------------
    speed_label = ttk.Label(frame, text='Enter number between 0 to 200 for Robot Speed')
    speed_label.grid()

    speed_entry = ttk.Entry(frame)
    speed_entry.grid()

    turn_label1 = ttk.Label(frame, text='Enter number between 0 to 200 for Robot Turning Speed.')
    turn_label1.grid()
    turn_label2 = ttk.Label(frame, text='0 = no turn, 200 = Sharpest Turn')
    turn_label2.grid()

    turn_entry = ttk.Entry(frame)
    turn_entry.grid()

    forward_button = ttk.Button(frame, text='Forward')
    forward_button.grid()
    forward_button['command'] = (lambda: Forward(dc, speed_entry))

    backward_button = ttk.Button(frame, text='Backward')
    backward_button.grid()
    backward_button['command'] = (lambda: Backward(dc, speed_entry))

    right_button = ttk.Button(frame, text='Right')
    right_button.grid()
    right_button['command'] = (lambda: Right(dc, speed_entry, turn_entry))

    left_button = ttk.Button(frame, text='Left')
    left_button.grid()
    left_button['command'] = (lambda: Left(dc, speed_entry, turn_entry))

    stop_button = ttk.Button(frame, text='Stop')
    stop_button.grid()
    stop_button['command'] = (lambda: Stop(dc))

# Fictitious Bio----------------------------------------------------------------------

    bio_label1 = ttk.Label(frame, text='Say Hello or ask me a question?')
    bio_label1.grid()
    bio_label2 = ttk.Label(frame, text='List of questions that you can ask:')
    bio_label2.grid()
    bio_label3 = ttk.Label(frame, text='Hello')
    bio_label3.grid()
    bio_label4 = ttk.Label(frame, text='How are you?')
    bio_label4.grid()
    bio_label5 = ttk.Label(frame, text='Where are you from?')
    bio_label5.grid()
    bio_label6 = ttk.Label(frame, text='Do you have a family?')
    bio_label6.grid()
    bio_label7 = ttk.Label(frame, text='What is your dream career?')
    bio_label7.grid()

    question_entry = ttk.Entry(frame)
    question_entry.grid()

    bio_button = ttk.Button(frame, text='Conversate?')
    bio_button.grid()
    bio_button['command'] = (lambda: Bio(root, question_entry))

# Canvas----------------------------------------------------------------------

    canvas_button = ttk.Button(frame, text='Canvas')
    canvas_button.grid()
    canvas_button['command'] = (lambda: Canvas())


# End of my_frame ----------------------------------------------------------------------

    return frame


def connect_to_robot(entry_box, dc):

    wifly_number = int(entry_box.get())
    dc.robot.connect_to_wifly(wifly_number)
#     robot = rb.RoseBot()
#     robot.connect_wifly(wifly_number)
#
#     return robot


def Forward(dc, speed_entry):
    contents_of_entry_box1 = speed_entry.get()
    speed = int(contents_of_entry_box1)
    dc.robot.differential_drive.drive_pwm(speed, speed)


def Backward(dc, speed_entry):
    contents_of_entry_box1 = speed_entry.get()
    speed = int(contents_of_entry_box1)
    dc.robot.differential_drive.drive_pwm(-speed, -speed)


def Right(dc, speed_entry, turn_entry):
    contents_of_entry_box1 = speed_entry.get()
    speed = int(contents_of_entry_box1)
    contents_of_entry_box2 = turn_entry.get()
    turn = int(contents_of_entry_box2)
    dc.robot.differential_drive.drive_pwm(speed, speed - turn)


def Left(dc, speed_entry, turn_entry):
    contents_of_entry_box1 = speed_entry.get()
    speed = int(contents_of_entry_box1)
    contents_of_entry_box2 = turn_entry.get()
    turn = int(contents_of_entry_box2)
    dc.robot.differential_drive.drive_pwm(speed - turn, speed)


def Stop(dc):
    dc.robot.differential_drive.drive_pwm(0, 0)
    print('STOP ROBOT!!!')


def Bio(entry):

    a = 'Hello'
    b = 'How are you?'
    c = 'Where are you from?'
    d = 'Do you have a family?'
    e = 'What is your dream career?'

    if a == entry.get():
        print('Hello, My name is Chappie! I was original a')
        print('reject robot, until Deon Wilson reprogrammed')
        print('my system with his prototype artificial')
        print('intelligence. Before I was turned on we were')
        print('kidnapped by gangsters, Ninja, Yolandi, and')
        print('Amerika. Ninja made Deon leave so now I live')
        print('with Yolandi!')
        root1 = tkinter.Toplevel()
        frame1 = ttk.Frame(root1, padding=10, relief='ridge')
        frame1.grid()
        photo = tkinter.PhotoImage(file='2015-Chappie-pictures.gif')
        button1 = ttk.Button(frame1, image=photo)
        button1.image = photo
        button1.grid()

    elif b == entry.get():
        print('I am curious!')

    elif c == entry.get():
        print('I am from Johannesburg in South Africa')
        root2 = tkinter.Toplevel()
        frame2 = ttk.Frame(root2, padding=10, relief='ridge')
        frame2.grid()
        photo = tkinter.PhotoImage(file='johannesburg-south-africa.gif')
        button2 = ttk.Button(frame2, image=photo)
        button2.image = photo
        button2.grid()

    elif d == entry.get():
        print('Yes, My family is Yolandi and Ninja')
        root3 = tkinter.Toplevel()
        frame3 = ttk.Frame(root3, padding=10, relief='ridge')
        frame3.grid()
        photo = tkinter.PhotoImage(file='Family.gif')
        button3 = ttk.Button(frame3, image=photo)
        button3.image = photo
        button3.grid()

    elif e == entry.get():
        root4 = tkinter.Toplevel()
        print('My dream career is to be a robot gangster.')
        frame4 = ttk.Frame(root4, padding=10, relief='ridge')
        frame4.grid()
        photo = tkinter.PhotoImage(file='gangster_robot.gif')
        button4 = ttk.Button(frame4, image=photo)
        button4.image = photo
        button4.grid()

    else:
        print('I am sorry I do not understand.')


def Canvas():

    # Layout of Canvas

    root5 = tkinter.Toplevel()
    frame5 = ttk.Frame(root5, padding=10, relief='ridge')
    frame5.grid()

    frame5 = ttk.Frame(root5, padding=20)
    frame5.grid()

    # Initialize of Canvas

    pen_data = Pen_Data()

    instructions = 'Click the left mouse button to make shapes when a shape button is selected,\n'
    instructions = instructions + 'drag the left mouse button to draw when no shape button is selected '
    label = ttk.Label(frame5, text=instructions)
    label.grid(row=0, column=1)

    canvas = tkinter.Canvas(frame5, background='lightgray')
    canvas.grid(row=1, column=1)

    # Buttons on Mouse when Mouse is in Canvas

    canvas.bind('<Button-1>', lambda event: shape(event, pen_data))
    canvas.bind('<B1-Motion>',
                lambda event: left_mouse_drag(event, pen_data))
    canvas.bind('<B1-ButtonRelease>',
                lambda event: left_mouse_release(pen_data))  # @UnusedVariable

    # Buttons on Canvas

    red_button = ttk.Button(frame5, text='Red')
    red_button.grid(row=2, column=0)
    red_button['command'] = lambda: red(pen_data)

    orange_button = ttk.Button(frame5, text='Orange')
    orange_button.grid(row=3, column=0)
    orange_button['command'] = lambda: orange(pen_data)

    yellow_button = ttk.Button(frame5, text='Yellow')
    yellow_button.grid(row=4, column=0)
    yellow_button['command'] = lambda: yellow(pen_data)

    green_button = ttk.Button(frame5, text='Green')
    green_button.grid(row=5, column=0)
    green_button['command'] = lambda: green(pen_data)

    blue_button = ttk.Button(frame5, text='Blue')
    blue_button.grid(row=2, column=1)
    blue_button['command'] = lambda: blue(pen_data)

    purple_button = ttk.Button(frame5, text='Purple')
    purple_button.grid(row=3, column=1)
    purple_button['command'] = lambda: purple(pen_data)

    brown_button = ttk.Button(frame5, text='Brown')
    brown_button.grid(row=4, column=1)
    brown_button['command'] = lambda: brown(pen_data)

    black_button = ttk.Button(frame5, text='Black')
    black_button.grid(row=5, column=1)
    black_button['command'] = lambda: black(pen_data)

    none_button = ttk.Button(frame5, text='No Shape')
    none_button.grid(row=2, column=2)
    none_button['command'] = lambda: none(pen_data)

    circle_button = ttk.Button(frame5, text='Circle')
    circle_button.grid(row=3, column=2)
    circle_button['command'] = lambda: circle(pen_data)

    triangle_button = ttk.Button(frame5, text='Triangle')
    triangle_button.grid(row=4, column=2)
    triangle_button['command'] = lambda: triangle(pen_data)

    square_button = ttk.Button(frame5, text='Square')
    square_button.grid(row=5, column=2)
    square_button['command'] = lambda: square(pen_data)

    size_label = ttk.Label(frame5, text='Enter number between 1 to 500 to change size of shape.')
    size_label.grid(row=7, column=1)

    size_entry = ttk.Entry(frame5)
    size_entry.grid(row=8, column=1)

    size_button = ttk.Button(frame5, text='Enter Size')
    size_button.grid(row=9, column=1)
    size_button['command'] = lambda: size(size_entry, pen_data)

    root5.mainloop()


# Functions of Buttons on Mouse when over Canvas

def shape(event, data):

    if data.shape == 'circle':
        canvas = event.widget
        canvas.create_oval(event.x - 10, event.y - 10,
                       event.x + 10, event.y + 10,
                       fill=data.color, width=data.width,
                       outline=data.color)

    elif data.shape == 'triangle':
        n = 10 + data.width
        canvas = event.widget
        canvas.create_polygon(event.x, event.y - n,
                              event.x + n, event.y + n,
                              event.x - n, event.y + n,
                              fill=data.color)

    elif data.shape == 'square':
        canvas = event.widget
        canvas.create_rectangle(event.x - 10, event.y - 10,
                                event.x + 10, event.y + 10,
                                fill=data.color , width=data.width,
                                outline=data.color)

    else:
        return


def left_mouse_drag(event, data):

    # data.mouse_position_x and _y keep track of the PREVIOUS mouse
    # position while we are dragging.

    canvas = event.widget
    if data.is_dragging and data.shape == 'none':
        canvas.create_line(data.mouse_position_x, data.mouse_position_y,
                           event.x, event.y,
                           fill=data.color, width=data.width)
    else:
        data.is_dragging = True  # Start dragging

    data.mouse_position_x = event.x
    data.mouse_position_y = event.y


def left_mouse_release(data):
    data.is_dragging = False


# Functions of Buttons on Canvas

def red(data):
    data.color = 'red'

def orange(data):
    data.color = 'orange'

def yellow(data):
    data.color = 'yellow'

def green(data):
    data.color = 'green'

def blue(data):
    data.color = 'blue'

def purple(data):
    data.color = 'purple'

def brown(data):
    data.color = 'brown'

def black(data):
    data.color = 'black'

def none(data):
    data.shape = 'none'

def circle(data):
    data.shape = 'circle'

def triangle(data):
    data.shape = 'triangle'

def square(data):
    data.shape = 'square'

def size(entry, data):
    contents = entry.get()
    size = int(contents)
    data.width = size


# ----------------------------------------------------------------------
# If this module is running at the top level (as opposed to being
# imported by another module), then call the 'main' function.
# ----------------------------------------------------------------------
    if __name__ == '__main__':
        m0.main()
