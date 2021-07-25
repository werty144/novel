package com.example.novel

class SceneManager {
    val idBackgorundMap = mapOf<Int, String>(0 to "anime_tyan", 1 to "renesans_tyan", 2 to "anime_tyan")

    val idTextMap = mapOf<Int, String>(0 to "Sosi huyaru", 1 to "Jizn' horosha")

    fun sceneBackground(id: Int) = idBackgorundMap[id]

    fun sceneText(id: Int) = idTextMap[id]

    fun nextId(id: Int): Int {
        return (id + 1) % 2
    }

    fun nextScene(curScene: Scene): Scene = SimpleScene(nextId(curScene.id), curScene.layout, curScene.context)

}