# Highdeas Television

### New Features:
- Resizeable Window
- Direct interaction with tv via keyboard by:
  - typing number, then hitting ENTER
  - using the up/down arrow keys
- Less overhead to create new channels
- Ability to enable/disable sound
- Ability for channels to change over time (see the `TimeSlider` channel (5) for an example)

### Creating a New Channel:

- Create a `PixelPainter`
  - The only method you should need to implement is `pixelColor(long t, int x, int y);`
  - now, you can make your channels vary over time via the t parameter, or use it as a random seed
- Add the Pixel Painter to the `initChannels()` method in the `Main` file so the TV can use it


### Small Note:

Thanks so much for letting me take a look at this project - I had a lot of fun messing around. Please don't feel pressured to use any of the code in here, but if you find it helpful, help yourself!