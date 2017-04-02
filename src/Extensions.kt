@file:JvmName("FileUtils")

import com.android.dx.command.Main
import java.io.File

private fun String.isSupportedBinaryFormat() = (this.endsWith("jar") || this.endsWith("class"))
private fun File.isFileSupported() = this.name.isSupportedBinaryFormat()

private fun File.compileDex() {
    if (isFileSupported()) {
        Main.main(arrayOf("--dex", "--no-strict", "--output=${this.name}classes.dex", this.absolutePath))
    }
}

private fun File.findJarsInFolder() {
    listFiles().forEach(File::buildFrom)
}

fun File.buildFrom() {
    if (isDirectory) {
        findJarsInFolder()
    } else {
        compileDex()
    }
}

