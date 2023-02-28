.DEFAULT_GOAL := build-run

run-dist:
	make -C run-dist

build:
	make -C app build

test:
	make -C app test

report:
	make -C app report

build-run: build run

.PHONY: build