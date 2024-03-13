# Simple Scheduled Messages
A basic plugin that allows you to configure messages that will cycle in order with the specified delay time.

These messages use [MiniMessage Formatting](https://webui.advntr.dev/) and can be very basic or very complex.


| Command               | Permission         | Description                                           |
|-----------------------|--------------------|-------------------------------------------------------|
| `/smreload`           | messages.reload    | Allows the user to reload the configs                 |
| `/automessage toggle` | messages.toggle    | Allows the user to pause/resume auto-messages         |
| `/broadcastmsg`       | messages.broadcast | Allows the user to send a message to the whole server |

| **Permissions**      | Description                            |
|----------------------|----------------------------------------|
| `messages`           | Allows plugin functionality            |
| `messages.reload`    | Allows reloading the plugin            |
| `messages.toggle`    | Allows toggling auto-messages on/off   |
| `messages.broadcast` | Allows sending a message to the server |

## Default Config:
```yml
# delay between messages in seconds
delay-time: 10
messages-to-display:
  - "test"
  - "test 2"
  - "<red>Test in color</red>"
  - "<gradient:red:dark_blue>other test in color</gradient>"
```