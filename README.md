# CherryRenderer

A standalone UPnP MediaRenderer for Windows, Linux and (probably[*](#more-info)) macOS.

Cast videos from your Android/iOS phone etc to your PC as if it was a Smart TV!

CherryRenderer is built with JavaFX and [Cling](https://github.com/4thline/cling) (yes, I know it is no longer being maintained. I am planning to migrate to a more updated library in the near future).

## Instructions
 1. Make sure Java 8 is installed.
 2. Download and run CherryRenderer.jar.
 3. Open the control point application on your remote device.
 4. Connect to the CherryRenderer device.
 5. Start casting!


## Features
 - Basic UPnP MediaRenderer support
   - Play, Pause, Stop, Rewind, Fast Forward
 - Change the device's friendly name via Menu - Preferences
 - Keyboard support:
 
 | Function          | Key   |
 |----------         |:-----:|
 | Play/Pause        | Space |
 | Toggle fullscreen | F     |
 | Stop              | S     |
 | Rewind            | Left  |
 | Fast Forward      | Right |
 | Volume Up         | Up    |
 | Volume Down       | Down  |
 | Toggle Mute       | M     |

## Known bugs
 - There is currently no buffer handling, as in there are no indications of when a video is in the middle of buffering.
   - AFAIK this is a JavaFX limitation. There is MediaPlayer.Status.STALLED, but it doesn't seem to be called except in obscure situations that I still don't understand.
 - Certain control point applications that provide "queuing" functions may try to cast the previously played video in its history right before casting the new video, causing 2 videos to play at the same time.
   - While I try to minimize this from happening by stopping previous videos before loading a new video, on some edge cases this may still occur.
 - Certain video providers will expire their video links after a period of time. If you try to cast expired video links (such as queuing it and playing it after the previous one finished), a MEDIA_UNAVAILABLE or MEDIA_INACCESSIBLE error will be thrown.

## More Info
For more info such as what control point apps have been tested and what video formats CherryRenderer supports, click [here](MOREINFO.md).

*&ast;I do not own a macOS device, nor do my alpha testers, but technically as long as Java 8 is installed it should run fine.*

## Credits
 - [Cling](https://github.com/4thline/cling)
 - [easy-events](https://github.com/Fylipp/easy-events)
 - Special thanks to my alpha testers for testing this program when it was extremely buggy.