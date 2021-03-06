package com.gwg.spring.asm;
/**
 * Utility class exposing constants related to Spring's internal repackaging
 * of the ASM bytecode manipulation library (currently based on version 6.0).
 *
 * <p>See <a href="package-summary.html">package-level javadocs</a> for more
 * information on {@code org.springframework.asm}.
 *
 * @author Chris Beams
 * @since 3.2
 */
public final class SpringAsmInfo {

	/**
	 * The ASM compatibility version for Spring's ASM visitor implementations:
	 * currently {@link Opcodes#ASM6}.
	 */
	public static final int ASM_VERSION = Opcodes.ASM6;

}
