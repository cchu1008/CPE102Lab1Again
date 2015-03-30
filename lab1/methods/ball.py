import pygame

UP = -1
DOWN = 1
LEFT = -1
RIGHT = 1
NEUTRAL = 0

class Ball:
   def __init__(self, x, y, radius, color, dx, dy):
      self.x = x
      self.y = y
      self.radius = radius
      self.color = color
      self.dx = dx
      self.dy = dy

   def draw_ball(self, ball, screen):
      pygame.draw.ellipse(screen, ball.color,
         pygame.Rect(ball.x - ball.radius, ball.y - ball.radius,
            ball.radius * 2, ball.radius * 2)) 

   def get_x(self):
      return self.x

   def get_y(self):
      return self.y

   def get_radius(self):
      return self.radius

   def get_color(self):
      return self.color

   def get_dx(self):
      return self.dx

   def get_dy(self):
      return self.dy

