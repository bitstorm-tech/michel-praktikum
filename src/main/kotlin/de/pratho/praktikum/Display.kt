package de.pratho.praktikum

import java.awt.Image
import javax.imageio.ImageIO
import javax.swing.ImageIcon
import javax.swing.JFrame
import javax.swing.JLabel

object Display : JFrame("Gravity Simulator") {
    var moonLabel = JLabel()
    var rocketLabel = JLabel()

    fun start() {
        setSize(1000, 600)
        loadGraphics()
        defaultCloseOperation = JFrame.DISPOSE_ON_CLOSE
        isVisible = true
    }

    private fun loadGraphics() {
        var imageStream = Display::class.java.getResourceAsStream("/moon.jpg")
        val moonImage = ImageIO.read(imageStream).getScaledInstance(width, height, Image.SCALE_SMOOTH)
        moonLabel = JLabel(ImageIcon(moonImage))
        imageStream = Display::class.java.getResourceAsStream("/rocket.jpg")
        val rocketImage = ImageIO.read(imageStream)
        rocketLabel = JLabel(ImageIcon(rocketImage))
        moonLabel.add(rocketLabel)
        contentPane.add(moonLabel)
    }

    fun moveDown(distance: String) {
    }
}

fun main(args: Array<String>) {
    Display.start()
}
