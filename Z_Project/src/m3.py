"""
The Python Capstone Project.

CSSE 120 - Introduction to Software Development.
Team members: Jacob Pluta, Chase Horne, Dakota Rostron, Omotese Oyenbhen . (all of them).

The primary author of this module is: Jacob Pluta.
"""
# TODO: Put the names of ALL team members in the above where indicated.
#       Put YOUR NAME in the above where indicated.

import m0
import m1
import m2
import m4

import tkinter
from tkinter import ttk
import rosebot as rb

import tweepy


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

    frame = ttk.Frame(root, padding=10, relief='ridge')

    label = ttk.Label(frame, text='Jacob Pluta')
    label.grid()

    speed_box = ttk.Entry(frame)
    dc.speed_box = speed_box
    speed_box.grid()
    speed_label = ttk.Label(frame, text='Enter Speed: (0 - 200)')
    speed_label.grid()

    forward_button = ttk.Button(frame, text='Forward')
    forward_button['command'] = (lambda: forward(dc, speed_box))
    forward_button.grid()

    backward_button = ttk.Button(frame, text='Backward')
    backward_button['command'] = (lambda: backward(dc, speed_box))
    backward_button.grid()

    turn_box = ttk.Entry(frame)
    turn_box.grid()
    angle_label = ttk.Label(frame, text='Enter Turn Angle: (0 - 360)')
    angle_label.grid()

    left_button = ttk.Button(frame, text='Left')
    left_button['command'] = (lambda: left(dc, speed_box, turn_box))
    left_button.grid()

    right_button = ttk.Button(frame, text='Right')
    right_button['command'] = (lambda: right(dc, speed_box, turn_box))
    right_button.grid()

    tweet_entry = ttk.Entry(frame)
    tweet_entry.grid()
    tweet_button = ttk.Button(frame, text='Post to Twitter')
    tweet_button.grid()
    tweet_button['command'] = (lambda: tweet(tweet_entry))

    return frame

#----- Travel Functions -----

def connect_to_robot(entry_box, dc):

    wifly_number = int(entry_box.get())
    dc.robot.connect_to_wifly(wifly_number)

def forward(dc, speed_box):

    speed = int(speed_box.get())
    dc.robot.differential_drive.drive_pwm(speed, speed)

def backward(dc, speed_box):

    speed = int(speed_box.get())
    dc.robot.differential_drive.drive_pwm(-speed, -speed)

def left(dc, speed_box, turn_box):

    speed = int(speed_box.get())
    angle = int(turn_box.get())
    dc.robot.differential_drive.stop()
    dc.robot.differential_drive.drive_pwm(-speed, speed)
    dc.robot.connection.sleep(speed / (2 * angle))
    dc.robot.differential_drive.stop()
    forward(dc, speed_box)

def right(dc, speed_box, turn_box):

    speed = int(speed_box.get())
    angle = int(turn_box.get())
    dc.robot.differential_drive.stop()
    dc.robot.differential_drive.drive_pwm(speed, -speed)
    dc.robot.connection.sleep(speed / (2 * angle))
    dc.robot.differential_drive.stop()
    forward(dc, speed_box)

def stop(dc):
    dc.robot.differential_drive.stop()


#----- Tweeting -----


def tweet(tweet_entry):


    CONSUMER_KEY = 'dGyFCviTvXgEhxRr4FUc7k2h5'
    CONSUMER_SECRET = 'ZPwy7Y4l8e088Lnt8C8OyMy0HHqO5aSC2PEpTUMj28cBvVNRiN'
    ACCESS_KEY = '765755704363872261-xtVMGqCntjq0DAvpfK6djlOsTNGqQkB'
    ACCESS_SECRET = 'lNrEhzjV5HyxcvX3oMyW1vOaqXiLJST3PN2F7PfqwXB7Z'
    auth = tweepy.OAuthHandler(CONSUMER_KEY, CONSUMER_SECRET)
    auth.set_access_token(ACCESS_KEY, ACCESS_SECRET)
    api = tweepy.API(auth)
    api.update_status(status=tweet_entry.get())

# ----------------------------------------------------------------------
# If this module is running at the top level (as opposed to being
# imported by another module), then call the 'main' function.
# ----------------------------------------------------------------------
if __name__ == '__main__':
    m0.main()
