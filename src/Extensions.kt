@file:JvmName("FileUtils")

import java.io.File
import com.android.dx.command.Main

private fun String.isJar() = this.endsWith("jar")
private fun File.isJar() = this.name.isJar()

private fun File.compileDexFromJar() {
    if (!isJar()) {
        throw IllegalArgumentException("File should be a JAR!")
    }

    Main.main(arrayOf("--dex", "--output=${this.name}classes.dex", this.absolutePath))
}

private fun File.findJarsInFolder() {
    listFiles().forEach(File::buildFrom)
}

fun File.buildFrom() {
    if (isDirectory) {
        findJarsInFolder()
    } else {
        compileDexFromJar()
    }
}

