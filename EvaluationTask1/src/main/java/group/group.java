package group;

import javax.validation.GroupSequence;

public interface group {
	public interface Group1 {}
	public interface Group2 {}
	public interface Group3 {}

	@GroupSequence({Group1.class,Group2.class,Group3.class})
	public interface All {}
}
