package de.pratho.praktikum

import java.awt.Color
import java.awt.Dimension
import java.awt.Image
import java.awt.Rectangle
import javax.imageio.ImageIO
import javax.swing.ImageIcon
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JLayeredPane

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
        val mainPane = JLayeredPane()
        mainPane.preferredSize = Dimension(800, 600)
        mainPane.background = Color.BLUE

        val imageStreamMoon = Display::class.java.getResourceAsStream("/moon.jpg")
        val moonImage = ImageIO.read(imageStreamMoon).getScaledInstance(width, height, Image.SCALE_SMOOTH)
        moonLabel = JLabel(ImageIcon(moonImage))
        moonLabel.bounds = Rectangle(0, 0, width, height)

        val imageStreamRocket = Display::class.java.getResourceAsStream("/rocket.jpg")
        val rocketImage = ImageIO.read(imageStreamRocket)
        rocketLabel = JLabel(ImageIcon(rocketImage))
        rocketLabel.bounds = Rectangle(50, 50, 101, 209)

        mainPane.add(moonLabel)
        mainPane.add(rocketLabel)
        mainPane.moveToFront(rocketLabel)

        add(mainPane)
    }

    fun moveDown(distance: Int) {
        rocketLabel.bounds = Rectangle(50, distance, 101, 209)
    }
}

fun main(args: Array<String>) {
    Display.start()
    for(distance in 5 .. 20) {
        Thread.sleep(100)
        Display.moveDown(distance*10)
    }
}
