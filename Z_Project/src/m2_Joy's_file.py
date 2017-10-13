"""
The Python Capstone Project.

CSSE 120 - Introduction to Software Development.
Team members: Chase Horne Oyenbhen Omotese Jacob Pluta Dakota Jassmin Rostron.

The primary author of this module is: Oyenbhen Omotese.
"""
# TODO: Put the names of ALL team members in the above where indicated.
#       Put YOUR NAME in the above where indicated.

import m0
import m1
import m3
import m4
import random
import math
import time
import tkinter
from tkinter import ttk
import rosebot as rb


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
    frame_0 = ttk.Frame(root, padding=10, relief='ridge')

    label = ttk.Label(frame_0, text='Oyenbhen')
    label.grid()

    label_4 = ttk.Label(frame_0, text='SONG')
    label_4.grid()

    label_5 = ttk.Label(frame_0, text='Key')
    label_5.grid()
    key_entry = ttk.Entry(frame_0)
    key_entry.grid()

    label3 = ttk.Label(frame_0, text='WAYPOINTS: ')
    label3.grid(column=1)
    xlabel = ttk.Label(frame_0, text='X Coordinate:')
    xlabel.grid(column=1)
    xentry = ttk.Entry(frame_0)
    xentry.grid(column=1)
    ylabel = ttk.Label(frame_0, text='Y Coordinate: ')
    ylabel.grid(column=1)
    yentry = ttk.Entry(frame_0)
    yentry.grid(column=1)
    button = ttk.Button(frame_0, text='Go!', padding=5)
    button.grid(column=1)
    button['command'] = (lambda:SimplerWaypoint(dc, xentry.get(), yentry.get()))


    song_button = ttk.Button(frame_0, text='Create')
    song_button.grid()
    song_button['command'] = (lambda: Play_Song(dc, key_entry.get()))

    camera_button = ttk.Button(frame_0, text='camera')
    camera_button.grid()
    camera_button['command'] = (lambda: Camera(dc))

    return frame_0

def Spin_Right(dc, radians):
    deg = math.degrees(radians)
    dc.robot.differential_drive.spin_right_degrees_per_sec(10)
    print('Right:', deg / 10)
    time.sleep(deg / 10)
    dc.robot.differential_drive.stop()

def Spin_Left(dc, radians):
    deg = math.degrees(radians)
    dc.robot.differential_drive.spin_left_degrees_per_sec(10)
    print('Left:', deg / 10)
    time.sleep(deg / 10)
    dc.robot.differential_drive.stop()

def SimplerWaypoint(dc, x_entry, y_entry):
    xlist = x_entry.split(',')
    ylist = y_entry.split(',')

    for k in range(len(xlist)):
        x = int(xlist[k])
        y = int(ylist[k])
        if x > 0:
            m3.right(dc)
            m3.forward(dc, x)
            m3.left(dc)

        elif x < 0:
            m3.left(dc)
            m3.forward(dc, x)
            m3.right(dc)

        if y > 0:
            m3.forward(dc, y)

        elif y < 0:
            m3.backward(dc, y)

def Camera(dc):

    while True:
        block = dc.robot.camera.get_block()
        if block != None:
            if block.x < 160:
                dc.robot.differential_drive.drive(30, 15)
                dc.robot.connection.sleep(0.5)
                print('whats my x', block.x)
            else:
                dc.robot.differential_drive.drive(15, 30)
                dc.robot.connection.sleep(0.5)
            if block.x == 160:
                dc.robot.differential_drive.drive(15, 15)
                dc.robot.connection.sleep(0.5)
            if block.width * block.height > 4500:
                dc.robot.differential_drive.drive(-10, -10)
                dc.robot.connection.sleep(0.5)
            # if block.height > 200:
            #    dc.robot.differential_drive(-10, 10)
            #    dc.robot.sleep(0.5)
    dc.robot.differential_drive.brake()

def Play_Song(dc, key_entry):
    key = key_entry
    C_major = [532, 239, 587, 659, 329, 349, 392, 220, 247, 262, 294]
    E_flat = [532, 239, 622, 698, 208, 233, 262, 294, 311, 330, 349, 392, 415, 466, 523, 587, 622]
    D_flat = [554, 622, 698, 740, 831, 932, 523, 554, 311, 349]
    F_major = [659, 698, 392, 220, 233, 262, 329]

    length = random.randint(1, 3)
    if str('c major') == key:
        for _ in range(len(C_major)):
            dc.robot.buzzer.play_frequency(C_major[random.randint(0, len(C_major) - 1)], length)
            dc.robot.connection.sleep(length)
    if str('e flat') == key:
        for _ in range (len(E_flat)):
            dc.robot.buzzer.play_frequency(E_flat[random.randint(0, len(E_flat) - 1)], length)
            dc.robot.connection.sleep(length)
    if str('d flat') == key:
        for _ in range (len(D_flat)):
            dc.robot.buzzer.play_frequency(D_flat[random.randint(0, len(D_flat) - 1)], length)
            dc.robot.connection.sleep(length)
    if str('f major') == key:
        for _ in range (len(F_major)):
            dc.robot.buzzer.play_frequency(F_major[random.randint(0, len(F_major) - 1)], length)
            dc.robot.connection.sleep(length)

# ----------------------------------------------------------------------
# If this module is running at the top level (as opposed to being
# imported by another module), then call the 'main' function.
# ----------------------------------------------------------------------
if __name__ == '__main__':
    m0.main()
