# EventMessages
**Register custom messages for player join, death, kick, etc.**
With EventMessages you finally can get rid of these pesky standard messages of Bukkit.
But you can do even more! How 'bout automated notices like "Map is saving. Expect a little lag."
or custom death messages? Everything's possible.

## Features
- Color and formatting codes
- Variables
- Fully customizable
- Listen on every possible event
- Very vibrant: ask for a feature and will implement it in no time

## Installation
Simply download the `EventMessages.jar` and put it in your `plugins` folder.
Then reload or restart the server. That's it! EventMessages is up and running,
you can test it by rejoining your server or issueing the command `/em`.

You can now customize and tweak EventMessages to your likings. See [Configuration](https://github.com/CubixCraft/EventMessages#configuration).

If `/em` doesn't work, please refer to [Troubleshooting](https://github.com/CubixCraft/EventMessages#troubleshooting).

## Configuration
There are two ways of configuring EventMessages: The `config.yml` file and the in-game chat console.
We'll start with the `config.yml` file, which is located here `./plugins/EventMessages/config.yml`
and contains all of EventMessages settings.

### `config.yml`

There are two main nodes: `strings` is used for EventMessages internal messages
(you can translate to suit your server's language) whereas `messages` is the very core;
here are all the messages for the specific events defined.

#### `strings`
- `reloaded` is the message displayed when you reload EventMessages via `/em reload`.
- `configSet` is the message displayed when you set a message in-game via `/em set [event] [message]`.  
  This string takes the variables `%event` and `%message`.
- `configUnset` is the message displayed when you remove a message in-game via `/em unset [event]`.  
  This string takes the variable `%event`.

#### `messages`
Please read the [Development Notice](https://github.com/CubixCraft/EventMessages#development-notice).

You can listen on virtually every event. They are sorted into heir respective modules,
so everything stay clean and tidy. For a full list of the standard events, refer to [Events](https://github.com/CubixCraft/EventMessages#events).
Custom events are defined via `messages.custom.*`.

#### Example
It the easiest to understand EventMessages, by looking at the automatically generated `config.yml`.
```yaml
strings:
  reloaded: '&a>&f Reloaded EventMessages.'
  configSet: '&a>&f Set EventMessage for &6%event&f to &6''&r%message&6''&f.'
  configUnset: '&a>&f Removed EventMessage for &6%event&f.'
messages:
  player:
    join: '&6>&f %player is &aonline&f.'
    quit: '&6>&f %player is &coffline&f.'
    kick: '&6>&f %player was &ckicked&f.'
    ban: '&6>&f %player was &4banned&f.'
    death: '&6>&f %player died.'
```
Pretty self explanatory. If you still have questions, ask us in the forum thread. :)

After changing the values you have to reload the configuration via `/em reload`
or a complete server reload (`/reload`).

### In-game configuration
We always recommend to directly edit the `config.yml` and then `/em reload`,
becuase you directly see what you get and typing isn't such a hassle. But if you wish to use
the in-game chat or CLI, there you go.

EventMessages comes with three commands. You already learnt the first one: `/em reload` or `/emreload`.
This reloads the configuration.

The second is `/em set [event] [message]`, respectively `/emset [event] [message]` which sets a certain
message for an event. `[event]` has to be a valid node like `player.join`.  
Example:  
`/emset player.quit &4Bye, Bye %player.`

Disabling a message is easy as well. `/em unset [event]` or `/emunset [event]` is what you want.  
I personally think that those death notifications are quite pesky. So let's disable them.  
`/emunset player.death`

You could also use `/em set player.death` and just leave out the `[message]`. Just some syntax sugar.

## Permissions
By default OPs have the ability to use all the `/em` commands. If you want to give these permissions
to other use `eventmessages.*`. For a finer control look here:
- `eventmessages.reload` grants access to the `/em reload` command
- `eventmessages.admin` grants access to the (un-)setting command

## Events
- player
  - join
  - quit
  - kick
  - ban
  - death

## Troubleshooting
So far, we haven't encounterd any problems. Report us some. :D

## Development notice
EventMessages is still under heavy development. We're planing to implement more extras and stuff.
Currently EventMessages only supports the `player.(join|quit|kick|ban|death)` events.
But we're working on allowing *dynamic* access to all events, including custom events.