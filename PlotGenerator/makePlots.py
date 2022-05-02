from cProfile import label
import os
from sys import argv
import pandas as pd
import matplotlib.pyplot as plt

BAR_WIDTH = 0.5
OUT_DIRECTORY = os.path.join(os.path.dirname(__file__), 'out')
MAX_HEIGHT = 24


def plotSeries(series: pd.Series):
  lanes_1 = {}
  lanes_2 = {}
  for lane_name, car_count in zip(series.axes[0], series.array):
    street_name, lane_number = lane_name.split('_')
    (lanes_1 if lane_number == '1' else lanes_2)[street_name] = car_count

  plt.clf()
  plt.ylim(top=MAX_HEIGHT)

  plt.bar(lanes_1.keys(), lanes_1.values(),
          BAR_WIDTH, label='Left Lane', color='blue')
  plt.bar(lanes_2.keys(), lanes_2.values(), BAR_WIDTH,
          bottom=list(lanes_1.values()),  label='Right Lane', color='orange')

  plt.legend(loc=2)

  plt.savefig(os.path.join(OUT_DIRECTORY, f"out_{series.name:04d}.png"))
  print("created image", series.name, end='\r')


def makeAllPlots(filename: str):
  if not os.path.exists(OUT_DIRECTORY):
    os.mkdir(OUT_DIRECTORY)
  filename = os.path.join(os.path.dirname(__file__), filename)
  data = pd.read_csv(filename)

  data.apply(plotSeries, axis=1)


if __name__ == "__main__":
  makeAllPlots(argv[1] if len(argv) >= 2 else input("Enter csv file name: "))
