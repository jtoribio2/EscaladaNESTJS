import {
  Body,
  Controller,
  Delete,
  Get,
  Param,
  ParseIntPipe,
  Patch,
  Post,
  Query,
} from '@nestjs/common';

import { TipusViaService } from './tipus-via.service';
import { FilterTipusViaDto } from './dto/filter-tipus-via.dto';

@Controller('tipus-via')
export class TipusViaController {

  constructor(
    private readonly tipusViaService: TipusViaService,
  ) {}
  @Get()
  findAll(
    @Query() filterDto: FilterTipusViaDto,
  ) {
    return this.tipusViaService.findAll(filterDto);
  }

  @Get(':id')
  findOne(
    @Param('id', ParseIntPipe) id: number,
  ) {
    return this.tipusViaService.findOne(id);
  }
}