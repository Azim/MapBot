## MapBot by Azim
Basically a paper plugin, containing bot which renders game's world in a manner close to the way in-game maps are rendering it, but for entirety of worldborder.

## Installation
- Install it on your paper server
- Get a bot token as on [this guide](https://javacord.org/wiki/getting-started/creating-a-bot-account.html#create-a-bot-and-get-its-token) and put it in config file.
- Restart the server
- If you want to limit who can use the bot, you can enable roles check and put list of whitelisted [role ID](https://imgur.com/6cbprdJ)s there

## Config
```
bot:
  # bot token
  token: enter_it_here
  # bot prefix
  prefix: 'map '
  # if bot should send console message with link to invite it on server startup
  generate-invite: true
# how long (in ms) should we keep the old renders
cacheinterval-ms: 300000
# interval (in ticks) between automatic full-map renders
autorefresh: 18000
# amount of threads to use when rendering
threads: 4
map:
  # default size (in chunks) of map when no args are provided to render command
  default-size-x: 64
  default-size-z: 64
  # maximum size (in chunks) of render
  max-size-x: 1000
  max-size-z: 1000
  # default world to use when world isnt specified for full render
  default-world: world
roles:
  # if enabled, users must have these discord roles to use corresponding commands
  enabled: false
  # list of roles which can use fullrender
  fullrender:
  - 0
  - 1
  # list of roles which can use render
  render:
  - 0
  - 1
  ```

## TODO
- localization support and stuff
- a way to reload the thing without everything breaking to pieces
- proper nether support lol