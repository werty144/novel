package com.example.novel

class SceneManager {
    val idBackgorundMap = mapOf<Int, String>(0 to "anime_tyan", 1 to "renesans_tyan")

    fun nextId(id: Int): Int {
        return (id + 1) % 2
    }

    fun nextScene(curScene: Scene): Scene = Scene(nextId(curScene.id), curScene.layout, curScene.context)

}