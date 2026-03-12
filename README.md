<table style="width: 100%; border-collapse: collapse;">
 <tr>
  <td style="width: 124px; vertical-align: top; text-align: center;">
   <div style="display: flex; justify-content: center; align-items: center;">
    <img src="https://github.com/ZipeStudio/Vault/blob/main/design/mods/main/zipestudio.png?raw=true" title="It's me">
   </div>
  </td>
  <td style="vertical-align: top;">
   <div style="display: flex; flex-direction: column;">
    <div style="display: flex;">
     <a href="https://github.com/ZipeStudio/My-Totem-Sounds">
      <img src="https://github.com/ZipeStudio/Vault/blob/main/design/mods/main/github.png?raw=true" title="Github page">
     </a>
     <a href="https://modrinth.com/mod/my-totem-sounds">
      <img src="https://github.com/ZipeStudio/Vault/blob/main/design/mods/main/modrinth.png?raw=true" title="Modrinth page">
     </a>
     <a href="https://www.curseforge.com/minecraft/mc-mods/my-totem-sounds">
      <img src="https://github.com/ZipeStudio/Vault/blob/main/design/mods/main/curseforge.png?raw=true" title="CurseForge page">
     </a>
    </div>
    <div style="display: flex;">
     <a href="https://discord.com/invite/XmGF7rkkuY">
      <img src="https://github.com/ZipeStudio/Vault/blob/main/design/mods/main/discord.png?raw=true" title="Discord account">
     </a>
     <a href="https://t.me/zipeleaf">
      <img src="https://github.com/ZipeStudio/Vault/blob/main/design/mods/main/telegram.png?raw=true" title="Telegram channel">
     </a>
     <a href="https://ko-fi.com/zipestudio/tip">
      <img src="https://github.com/ZipeStudio/Vault/blob/main/design/mods/main/support.png?raw=true" title="Support me (thx)">
     </a>
    </div>
   </div>
  </td>
 </tr>
</table>

!["Description" Title](https://github.com/ZipeStudio/Vault/blob/main/design/mods/main/ZSdescription.png?raw=true)

**My Totem Sounds** is a Client-side mod that links custom Totem of Undying names to sounds from Resource Packs. Rename a totem in an anvil and if a matching sound exists, it plays when the totem activates.

It reads two files from resource packs: `sounds.json` (standard Minecraft sound registration) and `totem_mappings.json` (which links renamed totem names to sound IDs).<br>
Works with any resource pack, whether it's your own or one provided by a server. Perfect for personal use or server‑wide inside jokes.

# [Video Showcase](https://www.youtube.com/watch?v=Ycrk8voUG-A)

!["my totem sounds banner"](https://github.com/ZipeStudio/My-Totem-Sounds/blob/master/img/mts_banner.png?raw=true)

!["Compatibility" Title](https://github.com/ZipeStudio/Vault/blob/main/design/mods/main/ZScompatible.png?raw=true)

### Mod Compatibility
- Works with **any mod** that adds items with the `DEATH_PROTECTION` component.
- Fully compatible with similar and other resource packs.
- No conflicts — the mod only intercepts the totem activation sound event.

### Works great with [My Totem Doll](https://modrinth.com/mod/my_totem_doll) mod
Use both mods together for the ultimate totem personalization:  
**My Totem Doll** turns your totem into a mini‑figure of any player (just rename it to their nickname).  
**My Totem Sounds** lets you attach a custom sound to that same name.  
Now you can have a totem that looks like your friend *and* plays their catchphrase, a meme, or an inside joke when it saves you.

### Multiplayer Friendly

- The mod is **client‑side only** — you don't need to install it on the server.
- Other players (without the mod & resource pack) will hear the vanilla totem sound (or whatever sound their own setup provides).

### Custom Sounds (Resource Packs)

- All sound definitions and name‑to‑sound mappings are loaded from **resource packs**.
- Server owners can include a resource pack with their custom sounds and mapping file — players who accept the pack will automatically hear the custom sounds.
- You can also create your own personal pack to enjoy your own sounds.

### 🎨 Community Resource Packs

Here are some resource packs created by the community for **My Totem Sounds**.  
Click on the links to download and try them out!

|  | Name | Description                                                                                                                         | Download |
| :--: | :--: |:------------------------------------------------------------------------------------------------------------------------------------| :------- |
| <img src="https://github.com/ZipeStudio/My-Totem-Sounds/blob/master/img/packs/mtm_icon.png?raw=true" width="250" height="250"> | **My Totem Memes** | A pack that adds a touch of meme culture to your totems. Features sounds like "Za Warudo", Roblox "Oof", metal pipe, and many more! | <a href="https://modrinth.com/resourcepack/my-totem-memes" target="_blank" rel="noopener noreferrer">Modrinth</a><br><a href="https://www.curseforge.com/minecraft/texture-packs/my-totem-memes" target="_blank" rel="noopener noreferrer">CurseForge</a> |
| <img src="https://github.com/ZipeStudio/My-Totem-Sounds/blob/master/img/packs/tas_icon.png?raw=true" width="250" height="250"> | **Totem All Sounds** | A simple resource pack that lets you change totem sounds by renaming them on an anvil! Choose from hundreds of Minecraft sounds. | <a href="https://modrinth.com/resourcepack/totem-all-sounds" target="_blank" rel="noopener noreferrer">Modrinth</a> |
| <img src="https://github.com/ZipeStudio/My-Totem-Sounds/blob/master/img/packs/mts_pack_template.png?raw=true" width="250" height="250"> | *Your pack here!* | *Create a resource pack and share it with us!*                                                                                      | |

> 💡 **Want your pack featured?** Create one and submit it on our [Discord](https://discord.com/invite/XmGF7rkkuY). The best packs will be added to this list!

!["Configurable" Title](https://github.com/ZipeStudio/Vault/blob/main/design/mods/main/ZSconfigurable.png?raw=true)

To add your own sounds, create a resource pack with the following structure (the namespace can be anything, e.g. `mypack`):
<details>
<summary><b>Simple Resource Pack Structure</b></summary>

```
my_cool_pack/
└── assets/
    └── mypack/
        ├── sounds.json
        ├── totem_mappings.json
        └── sounds/
            ├── zipestudio_ww.ogg
            └── alarm_alert.ogg
```

- **`sounds.json`** – registers your sound events (standard Minecraft sound registration).
- **`totem_mappings.json`** – links renamed totem names to sound IDs.
- **`sounds/`** – folder for your `.ogg` files.

### sounds.json
```json
{
  "mypack:zipestudio":  { "sounds": ["mypack:zipestudio_ww"] },
  "mypack:alert":       { "sounds": ["mypack:alarm_alert"] }
}
```

### totem_mappings.json
```json
{
  "totem_mappings": [
    { "name": "ZipeStudio",     "sound": "mypack:zipestudio" },
    { "name": "Alert",          "sound": "mypack:alert" }
  ]
}
```
You can also use an array for multiple names:
```json
{ "name": ["no", "non", "nein", "нет", "いいえ"], "sound": "anotherpack:nope" }
```

Explanation:
- The sound event `mypack:zipestudio` in `sounds.json` points to `assets/mypack/sounds/zipestudio_ww.ogg`.
- In `totem_mappings.json`, the name `"ZipeStudio"` is linked to that sound, so a totem renamed to "ZipeStudio" will play `zipestudio_ww.ogg`.

This allows one sound to be triggered by several different names. The sound ID can belong to another resource pack (`anotherpack:help`) – as long as that pack is loaded, it will work.
</details>

!["Support" Title](https://github.com/ZipeStudio/Vault/blob/main/design/mods/main/ZSsupport.png?raw=true)

### Want to support mod and authors? Just tell everyone about this mod!

Yeah, you got it right. Just by advertising, you will support the mod and the creators well. The more people will know about this mod, the more downloads it will have, more downloads will give good motivation to authors and increase income from the site (literally free donation). **Remember, advertising must not be intrusive and annoying!**

### What you can do?
- Create resource packs for the mod and submit them to our Discord. The best ones will be featured on the mod's page.
- Make a video review / advertisement
- Share it on social media or Discord
- Tell your friends about this mod
- Add it to your modpack or just download and enjoy the game

> Every mention matters — thank you for helping the community grow 🤍

!["Licensing" Title](https://github.com/ZipeStudio/Vault/blob/main/design/mods/main/ZSlicensing.png?raw=true)

### [See the original mod repository](https://github.com/ZipeStudio/My-Totem-Sounds)